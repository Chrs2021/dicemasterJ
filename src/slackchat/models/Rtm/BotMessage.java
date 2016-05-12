package slackchat.models.Rtm;


/**
 * Created by chrs2021 on 5/12/2016.
 */
public class BotMessage {
    private int id;
    private MessageContainer.MessageTypes type;
    private String channel;
    private String text;

    public int getId() {
        return id;
    }

    public void setType(MessageContainer.MessageTypes type) {
        this.type = type;
    }

    public MessageContainer.MessageTypes getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
