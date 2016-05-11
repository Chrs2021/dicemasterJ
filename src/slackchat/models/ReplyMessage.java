package slackchat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ccampbell3 on 5/11/2016.
 */
public class ReplyMessage {

    @Expose
    @SerializedName("username")
    public String user;

    @Expose
    @SerializedName("text")
    public String message;

    @Expose
    @SerializedName("icon_emoji")
    public String emojiIcon;

    public String getUser() {
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getEmojiIcon() {
        return emojiIcon;
    }

    public void setEmojiIcon(String emojiIcon) {
        this.emojiIcon = emojiIcon;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
