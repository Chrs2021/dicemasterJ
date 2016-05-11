package slackchat.impl;

import javax.print.DocFlavor;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chrs2021 on 5/10/2016.
 */
public class QueryHandler implements Runnable {
    private Socket mSocket;
    private HashMap<String, String> mPostDataSet;

    public QueryHandler(Socket socket)
    {
        mSocket = socket;
    }

    @Override
    public void run() {
        BufferedWriter out;
        BufferedReader inData;
        String incomingLine = "";
        boolean done =false;
        try {
            out = new  BufferedWriter( new OutputStreamWriter(mSocket.getOutputStream()));
            inData = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

            while ((incomingLine = inData.readLine()).length() !=0){
                //basic output just testing
                if(incomingLine.startsWith("POST"))
                {
                    out.write("HTTP/1.0 200 OK\r");
                    out.newLine();
                    out.flush();
                }
                if(incomingLine.startsWith("Connection"))
                {
                    out.newLine();
                    out.flush();
                }
            }

            StringBuilder payload = new StringBuilder();
            while(inData.ready()){
                payload.append((char) inData.read());
            }

            processMessage(payload);

            out.write("{ \n \"username\": \"Casper\" , \"icon_emoji\": \":ghost:\" ,\"text\": \""+mPostDataSet.get("msg")+"\" \n}\r");
            out.flush();
            out.close();
            mSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void processMessage(StringBuilder rawData)
    {

        String[] postData = rawData.toString().split("&");

        mPostDataSet= new HashMap<String, String>();

        for(String value : postData)
        {
            String[] data = value.split("=");

            if(data[0].equals("text"))
            {
                data[1] = data[1].replace("+", " ");
                try {
                    //remove the funky url encoding it got from being post data
                    data[1]  = java.net.URLDecoder.decode(data[1], "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            mPostDataSet.put(data[0],data[1]);
        }
        addQueryProperty(mPostDataSet);
        //TODO: add notifier to alert a new message has arrived.
    }


    private void addQueryProperty(HashMap<String, String> dataDict) {
      String query =  dataDict.get("text");
         query =  query.replace(dataDict.get("trigger_word"),"");

        dataDict.put("msg",query);
    }
}
