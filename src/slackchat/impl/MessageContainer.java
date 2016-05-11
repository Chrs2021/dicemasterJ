package slackchat.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import slackchat.models.ReplyMessage;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by ccampbell3 on 5/11/2016.
 */
public class MessageContainer {
    private ReplyMessage messageToSend = new ReplyMessage();
    private BufferedWriter outputWriter;
    private Gson gson;

    public MessageContainer(BufferedWriter outputWriter)
    {
      this.outputWriter =  outputWriter;
        gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();

    }

    public void setUsername(String username) {
        messageToSend.setUser(username);
    }

    public void setIcon(String icon) {
        messageToSend.setEmojiIcon(icon);
    }

    public void setMessage(String message) {
        messageToSend.setMessage(message);
    }

    public void sendMessage() {
        try {
            String message = gson.toJson(messageToSend);

            outputWriter.write(message);
            outputWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
