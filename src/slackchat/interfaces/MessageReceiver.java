package slackchat.interfaces;

import slackchat.models.Rtm.MessageContainer;

/**
 * Created by chrs2021 on 5/12/2016.
 */
public interface MessageReceiver {
    void messageReceived(MessageContainer message);

}
