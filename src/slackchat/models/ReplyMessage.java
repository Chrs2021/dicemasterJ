package slackchat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ccampbell3 on 5/11/2016.
 */
public class ReplyMessage {

    @Expose
    @SerializedName("username")
    private String user;

    @Expose
    @SerializedName("text")
    private String message;

    @Expose
    @SerializedName("icon_emoji")
    private String emojiIcon;

    @Expose
    @SerializedName("icon_url")
    private String iconURL;


    public String getUser() {
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getEmojiIcon() {
        return emojiIcon;
    }

    public void setEmojiIcon(String icon) {
        if(icon.startsWith(":"))
            this.emojiIcon = icon;
        else
            this.iconURL = icon;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
