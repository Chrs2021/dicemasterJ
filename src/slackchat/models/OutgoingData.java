package slackchat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ccampbell3 on 5/11/2016.
 */
public class OutgoingData {
    @Expose
    @SerializedName("username")
    public String user;

    @Expose
    @SerializedName("text")
    public String message;

    @Expose
    @SerializedName("channel")
    public String channel;

    @Expose
    @SerializedName("icon_emoji")
    public String icon;

    public void setUser(String user) {
        this.user = user;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
