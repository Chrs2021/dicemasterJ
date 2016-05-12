package slackchat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ccampbell3 on 5/11/2016.
 */
public class OutgoingData {
    @Expose
    @SerializedName("username")
    private String user;

    @Expose
    @SerializedName("text")
    private String message;

    @Expose
    @SerializedName("channel")
    private String channel;

    @Expose
    @SerializedName("icon_emoji")
    private String icon;

    @Expose
    @SerializedName("icon_url")
    private String iconURL;

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
        if(icon.startsWith(":"))
            this.icon = icon;
        else
            this.iconURL = icon;
    }
}
