package slackchat.models.webcalls;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by ccampbell3 on 5/12/2016.
 */
public class WebContainer {
    public enum parseTypes{
        none,full
    }

    private String Token;
    private String user;
    private String text;
    private parseTypes parse;
    private String channel;
    private boolean as_user;
    private boolean unfurl_media;

    public void setAs_user(boolean as_user) {
        this.as_user = as_user;
    }

    public Boolean getAs_user() {
        return as_user;
    }

    public void setParse(parseTypes parss) {
        this.parse = parss;
    }

    public parseTypes getParse() {
        return parse;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Boolean setUnfurl_media() {
        return unfurl_media;
    }

    public void setUnfurl_media(boolean unfurl_media) {
        this.unfurl_media = unfurl_media;
    }
}
