package slackchat.impl;

import slackchat.interfaces.MessageClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RunnableFuture;

/**
 * Created by chrs2021 on 5/10/2016.
 */
public class webhookSession {

    private int mPort;
    private ServerSocket mServerSocket;
    private static List<MessageClient> botListeners;


    //TODO: check token from slack to make sure communication isn't spooked
    public webhookSession(String Token, int port)
    {

        botListeners = new ArrayList<>();
        mPort =  port;
        try {
            mServerSocket = new ServerSocket(mPort);

            Thread server = new Thread(new ServerThread(mServerSocket));

            server.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void addBotListener( MessageClient messageClient)
    {
        botListeners.add(messageClient);
        System.out.println();
    }

   private class ServerThread implements Runnable{
        private ServerSocket mServerSocket;

        public ServerThread(ServerSocket srvSocket)
        {
            mServerSocket = srvSocket;
        }

        @Override
        public void run() {
            while (true){
                //create
                Thread chatThread = null;
                try {
                    chatThread = new Thread(new QueryHandler(mServerSocket.accept(),botListeners));
                    chatThread.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
