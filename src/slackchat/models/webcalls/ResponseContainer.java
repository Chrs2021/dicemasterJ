package slackchat.models.webcalls;

import slackchat.models.Rtm.MessageContainer;
import slackchat.models.bot.Channels;

/**
 * Created by ccampbell3 on 5/12/2016.
 */
public class ResponseContainer {
    private Channels channel;
    private String user;
    private MessageContainer.MessageTypes type;
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

    public Channels getChannel() {
        return channel;
    }

    public String getUser() {
        return user;
    }

    public MessageContainer.MessageTypes getType() {
        return type;
    }
}
