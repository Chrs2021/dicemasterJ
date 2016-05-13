package dicebot;

import slackchat.models.Rtm.MessageContainer;
import slackchat.impl.bots.RtmSession;
import slackchat.impl.webhooks.webhookSession;
import slackchat.interfaces.MessageReceiver;
import slackchat.models.bot.Channels;
import slackchat.models.bot.RtmResponse;
import slackchat.models.bot.Users;

import java.awt.*;
import java.math.BigInteger;
import java.util.Map;
import java.security.SecureRandom;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static slackchat.models.Rtm.MessageContainer.MessageTypes.*;

public class Main {

    // Basically taking the place of the tables, with the key being the ID (more or less)
    private static Map<String, Player> players;
    private static Map<String, Duel> duels;
    private static RtmSession mBotSession;
    // Generates a 32-character string randomly for object assignment.
    private static String newString() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

    // Makes a new player. Will need to be heavily documented
    private static void createPlayer(String name) {
        String newID = newString();
        players.put(newID, new Player(newID, name));
    }

    //argument 1 is the port for webhooks, argument 2 is currently the authtoken for the bot
    public static void main(String[] args) {
        //this should be expanded out to do more stuff.
        webhookSession session = new webhookSession("", Integer.parseInt(args[0]));
        final RtmSession botSession = new RtmSession(args[1]);
        mBotSession = botSession;
        final RtmResponse sessionInfo = botSession.getSessionInfo();
        Users targetUser = null;
        //startPMTimer(botSession);
        botSession.AddMessageListener(new MessageReceiver() {
            @Override
            public void messageReceived(MessageContainer message) {
                if (message.getType() != null)
                    switch (message.getType()) {
                        case message:
                            if (message.getText() != null ) {
                                sendReply(message);
                            }
                            break;
                    }
            }
        });

    }

    private static void startPMTimer(final RtmSession botSession) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String presence = "";
                String isBot = "";
                String userID;
                int userNumber = 0;
                Users user;
                RtmResponse sessionInfo = botSession.getSessionInfo();
                while (!presence.equalsIgnoreCase("active") & !isBot.equalsIgnoreCase("false")) {
                    userNumber = ((int) (Math.random() * 100) % sessionInfo.getUsers().length);
                    presence = sessionInfo.getUsers()[userNumber].getPresence();
                    isBot = sessionInfo.getUsers()[userNumber].getIs_bot();
                }
                user = sessionInfo.getUsers()[userNumber];
                final String[] responses = {"Hi there, "+ user.getName(),"I'm bored", "You doing anything interesting?", "What's up", "Yo!"};

                userID = user.getId();
                Channels dmChannel = botSession.openDMSession(userID);
                botSession.sendSimpleMessage(responses[(int)(Math.random()*100) % responses.length], dmChannel.getId());
            }
        }, 10 * 1000, 30 * 60 * 1000);


    }

    public static void sendReply(final MessageContainer message)
    {

        Timer timer = new Timer();
        final String[] responses = {"you called, #"+ message.getUser(),"Are you lot gossipping about me again?", "What, What is it?", "That's my name...", "Ok"};

        Pattern pattern = Pattern.compile("[dD]([\\d+]{1,3})");
        final Matcher matcher = pattern.matcher(message.getText());
        final boolean foundString = matcher.find();
        if(message.getText().contains("resta")|| foundString)
            mBotSession.setTypingStatus(MessageContainer.MessageTypes.typing, message.getChannel());

            timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(foundString) {
                        final String found = matcher.group(1);
                        mBotSession.sendSimpleMessage( String.valueOf((int)(Math.random()*1500 % Integer.parseInt(found)-1)+1)  , message.getChannel());
                }else if (message.getText().contains(mBotSession.getSessionInfo().getSelf().getName())){
                    mBotSession.sendSimpleMessage(  responses[(int)(Math.random()*100) % responses.length]
                            , message.getChannel());
                }//
            }
        },3*1000);
    }
}
