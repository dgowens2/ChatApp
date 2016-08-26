package com.tiy.homework;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by DTG2 on 08/25/16.
 */
public class ChatAppRunner {
    public static void main(String[] args) throws IOException {
        System.out.println("Running");

        ChatAppServer myServer = new ChatAppServer();
        myServer.startServer();
        ChatAppConnectionHandler myhandler = new ChatAppConnectionHandler();
        myhandler.run();



    }
}
