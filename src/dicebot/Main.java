package dicebot;

import slackchat.models.Rtm.MessageContainer;
import slackchat.impl.bots.RtmSession;
import slackchat.impl.webhooks.webhookSession;
import slackchat.interfaces.MessageReceiver;
import slackchat.models.bot.RtmResponse;

import java.math.BigInteger;
import java.util.Map;
import java.security.SecureRandom;

import static slackchat.models.Rtm.MessageContainer.types.*;

public class Main {

    // Basically taking the place of the tables, with the key being the ID (more or less)
    private static Map<String,Player> players;
    private static Map<String,Duel> duels;

    // Generates a 32-character string randomly for object assignment.
    private static String newString() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

    // Makes a new player. Will need to be heavily documented
    private static void createPlayer(String name) {
        String newID = newString();
        players.put(newID,new Player(newID,name));
    }

    //argument 1 is the port for webhooks, argument 2 is currently the authtoken for the bot
    public static void main(String[] args) {
        //this should be expanded out to do more stuff.
        webhookSession  session = new webhookSession("",Integer.parseInt(args[0]));
        final RtmSession botSession = new RtmSession(args[1]);
        final RtmResponse sessionInfo = botSession.getSessionInfo();
        botSession.AddMessageListener(new MessageReceiver() {
            @Override
            public void messageReceived(MessageContainer message){
                if(message.getType()!=null)
                switch (message.getType())
                {
                    case message:
                        if(message.getText()!=null && message.getText().contains(sessionInfo.getSelf().getName()))
                        {
                            botSession.sendSimpleMessage("Stop talking about me!!!",sessionInfo.getChannels()[0].getId());
                        }
                        break;
                }
            }
        });

    }
}
