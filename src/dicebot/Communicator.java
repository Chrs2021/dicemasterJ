package dicebot;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jbird on 1/6/16.
 * This class is for the express purpose of communicating with whatever
 * medium is being used to work with dicemaster.
 */
public class Communicator {
    // The listen() function will be for waiting on slash commands
    public static void slackListen(String URL,int port) {
        try (
            ServerSocket servSock = new ServerSocket(port);
            Socket clieSock = servSock.accept();
            PrintWriter out = new PrintWriter(clieSock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clieSock.getInputStream()));
        ) {
            String inLine;
            for (int i = 1;(inLine = in.readLine()) != null;i++) {
                System.out.println("This is line " + i + ":    " + inLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // The slackSendReq() functions are for sending hooks to Slack
    public static void slackSendReq(String url, String mesg, String name, String icon) {
        HttpClient hClient = new HttpClient();
        PostMethod pMethod = new PostMethod(url);
        // jMesg stores the data we're sending to Slack.
        // "text" is the actual text that will show up.
        String jMesg = "{\"text\":\"" + mesg + "\"";
        // "username" is what the username will show up as
        if (!name.isEmpty()) {
            jMesg = jMesg + ",\"username\":\"" + name + "\"";
        }
        // "icon_url" is a link to the picture that will show up for the bot
        if (!icon.isEmpty()) {
            jMesg = jMesg + ",\"icon_emoji\":\"" + icon + "\"";
        }
        jMesg = jMesg + "}";
        pMethod.addParameter("payload", jMesg);
        try {
            hClient.executeMethod(pMethod);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Code: " + pMethod.getStatusCode());
    }
    // in case you don't want a picture
    public static void slackSendReq(String url, String mesg, String name) {
        slackSendReq(url,mesg,name,"");
    }
    // in case you don't want a nice name
    public static void slackSendReq(String url, String mesg) {
        slackSendReq(url,mesg,"");
    }
}
