package com.tiy.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by DTG2 on 08/25/16.
 */
public class ChatAppServer implements Runnable {

    public void run() {

    }

    public void startServer() {
        try {
            System.out.println("Server opening...");
            ServerSocket serverListener = new ServerSocket(8585);
            System.out.println("The audience is listening...");

            while (true) {
                Socket incomingConnection = serverListener.accept();
                System.out.println("I received an incoming client connection");
                ChatAppConnectionHandler handler = new ChatAppConnectionHandler(incomingConnection);
                Thread handlerThread = new Thread(handler);
                handlerThread.start();

            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }


}
