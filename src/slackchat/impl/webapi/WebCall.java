package slackchat.impl.webapi;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import slackchat.impl.bots.RtmSession;
import slackchat.models.Rtm.MessageContainer;
import slackchat.models.bot.RtmResponse;
import slackchat.models.webcalls.ResponseContainer;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by ccampbell3 on 5/12/2016.
 * this is a shell for a web api call to be extended to do other things.
 *
 */
public class WebCall {
    private String mToken;
    private HashMap<String, String> params;
    protected HttpClient mClient;
    protected HttpGet mHttpGet;
    protected final static  String BASE_API_URL = "https://slack.com/api/";

    public WebCall(String token,String apiCall)
    {
        mToken = token;
        mClient = HttpClients.createDefault();

    }

    public ResponseContainer executeCall()
    {
        ResponseContainer responseMessage = null;

        try {
        HttpResponse response = mClient.execute(mHttpGet);
        HttpEntity entity = response.getEntity();
        String responseString = null;
            responseString = EntityUtils.toString(entity, "UTF-8");
            responseMessage = RtmSession.getGsonInstance().fromJson(responseString,ResponseContainer.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseMessage;
    }
}
