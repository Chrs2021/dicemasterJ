package slackchat.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by chrs2021 on 5/10/2016.
 */
public class webhookSession {

    private int mPort;
    private ServerSocket mServerSocket;
    private Socket mSocket;


    public webhookSession(String Token, int port)
    {

        mPort =  port;
        try {
            mServerSocket = new ServerSocket(mPort);


            while (true){
                //create
                Thread chatThread = new Thread(new QueryHandler(mServerSocket.accept()));
                chatThread.start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
