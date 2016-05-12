package slackchat.impl.bots;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import slackchat.impl.webapi.OpenDM;
import slackchat.interfaces.MessageReceiver;
import slackchat.models.Rtm.BotMessage;
import slackchat.models.Rtm.MessageContainer;
import slackchat.models.bot.Channels;
import slackchat.models.bot.RtmResponse;
import slackchat.models.webcalls.ResponseContainer;
import slackchat.models.webcalls.WebContainer;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by chrs2021 on 5/11/2016.
 */

@WebSocket
public class RtmBot {
    private RtmResponse mRtmResponse;
    private Session socketIface;
    private Gson gson;
    private List<MessageReceiver> mMessageListeners;
    public  RtmBot(RtmResponse responseData) throws IOException {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        mRtmResponse = responseData;
        gson = RtmSession.getGsonInstance();
        SslContextFactory sslContextFactory = new SslContextFactory();

        //not really safe but we're not doing credit card transactions so fuck it....
        sslContextFactory.setTrustAll(true); // The magic

        WebSocketClient client = new WebSocketClient(sslContextFactory);
        try
        {
            client.start();
            Future<Session> fut = client.connect(this, URI.create(mRtmResponse.getUrl()));
            socketIface = fut.get();

        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
    }

    @OnWebSocketConnect
    public void onConnect(Session sess)
    {
        System.out.println(sess);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason)
    {
        System.out.print( statusCode + " " + reason);
    }

    @OnWebSocketError
    public void onError(Throwable cause)
    {
        System.out.println(cause);
    }

    @OnWebSocketMessage
    public void onMessage(String msg)
    {
        MessageContainer messageContainer = gson.fromJson(msg,MessageContainer.class);

         if(mMessageListeners!=null) {
            for (MessageReceiver receiver : mMessageListeners) {
                receiver.messageReceived(messageContainer);
            }
        }
    }

    public void addMessageListener(MessageReceiver messageReceiver)
    {
        if(mMessageListeners==null) {
            mMessageListeners = new ArrayList<>();
        }

        mMessageListeners.add(messageReceiver);

    }

    public void sendMessage(String message,String channel)
    {
        BotMessage msg = new BotMessage();
        msg.setId(1);
        msg.setType(MessageContainer.MessageTypes.message);
        msg.setChannel(channel);
        msg.setText(message);
        String payload =  gson.toJson(msg, BotMessage.class);
        try {
            socketIface.getRemote().sendString(payload);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Channels createDMChannel(String user)
    {
        WebContainer params = new WebContainer();
        params.setUser(user);
        params.setToken(RtmSession.getToken());
        OpenDM dm = new OpenDM(RtmSession.getToken(),"im.open" , params);
        ResponseContainer message = dm.executeCall();

        return message.getChannel();
    }

    public void setTypingStatus(MessageContainer.MessageTypes type, String channel) {
        BotMessage msg = new BotMessage();
        msg.setId(1);
        msg.setChannel(channel);
        msg.setType(type);

        String payload =  gson.toJson(msg, BotMessage.class);
        try {
            socketIface.getRemote().sendString(payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
