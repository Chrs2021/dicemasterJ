package slackchat.impl.bots;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import slackchat.interfaces.MessageReceiver;
import slackchat.models.Rtm.MessageContainer;
import slackchat.models.bot.Channels;
import slackchat.models.bot.RtmResponse;

import java.io.IOException;
import java.util.List;

/**
 * Created by chrs2021 on 5/11/2016.
 */
public class RtmSession {
    private RtmBot bot;
    private static Gson gson;
    private RtmResponse mSessionInfo;
    private static String mToken;

    public RtmSession(String token) {
        gson = new GsonBuilder().create();
        mToken = token;

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://slack.com/api/rtm.start?token=" + token);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            mSessionInfo = gson.fromJson(responseString,RtmResponse.class);
            bot = new RtmBot(mSessionInfo);


        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void AddMessageListener(MessageReceiver messageReceiver) {
        bot.addMessageListener(messageReceiver);
    }

    public RtmResponse getSessionInfo() {
        return mSessionInfo;
    }

    public static String getToken() {
        return mToken;
    }

    public static Gson getGsonInstance() {
        return gson;
    }


    public Channels openDMSession(String user)
    {
       Channels dmChannel  = bot.createDMChannel(user);

        return dmChannel;
    }

    public void setTypingStatus(MessageContainer.MessageTypes type, String Channel){
        bot.setTypingStatus(type,Channel);
    }

    public void sendSimpleMessage(String msg, String channel) {
        bot.sendMessage(msg, channel);
    }
}
