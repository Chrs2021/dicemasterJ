package dicebot;

import java.math.BigInteger;
import java.util.Map;
import java.security.SecureRandom;
import java.util.Scanner;

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

    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore","/etc/letsencrypt/keys/0000_key-letsencrypt.pem");
        Communicator.SSLSlackListen("dice.adhdtv.xyz",443);
    }
}
