package slackchat.impl.webhooks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import slackchat.models.OutgoingData;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccampbell3 on 5/11/2016.
 */
public class webhooksIncoming {
    private String mHookURL;
    private Gson gson;
    //Todo: design a subsystem to support un
    public webhooksIncoming(String URL)
    {
        mHookURL = URL;
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
    }

    public void SendMessage(OutgoingData data)
    {
        List<BasicNameValuePair> params = new ArrayList<>();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost =  new HttpPost(mHookURL);
        String payload = gson.toJson(data);
        params.add(new BasicNameValuePair("payload", payload));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            HttpResponse response = client.execute(httpPost);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
