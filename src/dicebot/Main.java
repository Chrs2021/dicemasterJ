package dicebot;

import slackchat.impl.MessageContainer;
import slackchat.impl.webhookSession;
import slackchat.impl.webhooksIncoming;
import slackchat.interfaces.MessageClient;
import slackchat.models.OutgoingData;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;
import java.security.SecureRandom;

public class Main {

    // The URL we're sending POSTs to
    private static String URL = "https://hooks.slack.com/services/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";

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

    /*
    // Function for testing communication with Slack
    private static void chatTest() {
        boolean go = true;
        String mesg;
        char answer;
        Scanner scan = new Scanner(System.in);
        while (go) {
            System.out.println("What shall we say?");
            mesg = scan.nextLine();
            Communicator.slackSendReq(URL,mesg);
            System.out.print("Continue? y/n");
            answer = scan.nextLine().charAt(0);
            if (answer == 'n') {
                go = false;
            }
        }
    }
    */
    public static void main(String[] args) {
        //this should be expanded out to do more stuff.
        webhookSession  session = new webhookSession("",Integer.parseInt(args[0]));

        webhooksIncoming unsolicitedMessager = new webhooksIncoming(args[1]);

        OutgoingData onlineMessage = new OutgoingData();
        onlineMessage.setMessage("Bots Are Go!");
        onlineMessage.setUser("Bot Manager");
        onlineMessage.setChannel("#general");
        onlineMessage.setIcon(":100:");
        unsolicitedMessager.SendMessage(onlineMessage);

        session.addBotListener(new MessageClient() {
            @Override
            public void messageReceived(String from, String channel, String msg, String trigger_word, MessageContainer outputMessage) {
                //this is a bot response method...
               outputMessage.setUsername(trigger_word);
                outputMessage.setIcon(":ghost:");
                outputMessage.setMessage(msg);
                outputMessage.sendMessage();
            }
        });
    }
}
