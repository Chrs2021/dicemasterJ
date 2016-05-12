package slackchat.impl.webapi;

import org.apache.http.client.methods.HttpGet;
import slackchat.models.webcalls.WebContainer;

/**
 * Created by ccampbell3 on 5/12/2016.
 */
public class OpenDM extends WebCall {

   public OpenDM(String token, String apiCall, WebContainer data)
    {
        super(token,apiCall);

        //kind of hokey need to think of something better
        String payload = "";
        payload +="token="+ data.getToken()+"&";
        payload +="user="+ data.getUser()+"&";

        super.mHttpGet = new HttpGet(super.BASE_API_URL + "/" + apiCall +"?"+payload);
    }
}
