package slackchat.interfaces;

import slackchat.impl.webhooks.Messenger;

/**
 * Created by ccampbell3 on 5/11/2016.
 */
public interface MessageClient {

    /*
     * Message Received - this gets fired when
     * @param from shows who sent the message
     * @param channel shows which channel the request came from
     * @param msg the message sent to the bot
     * @param trigger_word the trigger used to call the bot
     * @param outputWriter the output buffer to send back to slack
     */
    void messageReceived(String from, String channel, String msg, String trigger_word, Messenger outputMessage);

}
