package slackchat.models.Rtm;

import java.nio.channels.Channel;

/**
 * Created by chrs2021 on 5/12/2016.
 */
public class MessageContainer {
    public enum  types{
        error,message,presence_change,user_typing,typing,im_created,reconnect_url,hello
    }
    private String channel;
    private String user;
    private types type;
    private Boolean ok;
    private String url;
    private double ts;
    private String text;

    //TODO: make sub classes to handle different fields
    //

    public double getTs() {
        return ts;
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getOk() {
        return ok;
    }

    public String getChannel() {
        return channel;
    }

    public String getUser() {
        return user;
    }

    public types getType() {
        return type;
    }
}
