package dicebot;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

/**
 * Created by jbird on 1/6/16.
 * This class is for the express purpose of communicating with whatever
 * medium is being used to work with dicemaster.
 */
public class Communicator {
    public static void sendReq(String url,String mesg,String name,String icon) {
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
            jMesg = jMesg + ",\"icon_url\":\"" + icon + "\"";
        }
        jMesg = jMesg + "}";
        pMethod.addParameter("payload", jMesg);
        try {
            hClient.executeMethod(pMethod);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Code: " + pMethod.getStatusCode());
    }
    // in case you don't want a picture
    public static void sendReq(String url,String mesg,String name) {
        sendReq(url,mesg,name,"");
    }
    // in case you don't want a nice name
    public static void sendReq(String url,String mesg) {
        sendReq(url,mesg,"");
    }
}
