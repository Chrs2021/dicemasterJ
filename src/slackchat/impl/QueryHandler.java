package slackchat.impl;

import slackchat.interfaces.MessageClient;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 * Created by chrs2021 on 5/10/2016.
 */
public class QueryHandler implements Runnable {
    private Socket mSocket;
    private HashMap<String, String> mPostDataSet;
    private List<MessageClient> messageClientListener;
    private BufferedWriter mOutput;

    public QueryHandler(Socket socket, List<MessageClient> botListeners)
    {
        messageClientListener = botListeners;
        mSocket = socket;
    }

    @Override
    public void run() {
        BufferedWriter out;
        BufferedReader inData;
        String incomingLine;
        try {
            mOutput = new  BufferedWriter( new OutputStreamWriter(mSocket.getOutputStream()));
            inData = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

            while ((incomingLine = inData.readLine()).length() !=0){
                //basic output just testing
                if(incomingLine.startsWith("POST"))
                {
                    mOutput.write("HTTP/1.0 200 OK\r");
                    mOutput.newLine();
                    mOutput.flush();
                }
                if(incomingLine.startsWith("Connection"))
                {
                    mOutput.newLine();
                    mOutput.newLine();
                    mOutput.flush();
                }
            }

            StringBuilder payload = new StringBuilder();
            while(inData.ready()){
                payload.append((char) inData.read());
            }

            processMessage(payload);

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

        for (MessageClient client: messageClientListener) {
            client.messageReceived(mPostDataSet.get("user_name"),mPostDataSet.get("channel_name"),
                    mPostDataSet.get("msg"), mPostDataSet.get("trigger_word"), new MessageContainer(mOutput));

        }

        try {
            mOutput.flush();
            mOutput.close();
            mSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addQueryProperty(HashMap<String, String> dataDict) {
         String query =  dataDict.get("text");
         query =  query.replace(dataDict.get("trigger_word"),"");

         dataDict.put("msg",query);
    }
}
