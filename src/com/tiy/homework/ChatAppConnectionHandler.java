package com.tiy.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by DTG2 on 08/25/16.
 */
public class ChatAppConnectionHandler implements Runnable {

    Socket connection;

    public void run(){
        try{
            handleIncomingConnection(connection);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public ChatAppConnectionHandler(){

    }

    public ChatAppConnectionHandler(Socket connection) {
        this.connection = connection;
    }

    private void handleIncomingConnection (Socket clientSocket) throws IOException {
        System.out.println("Connection Accepted");

        System.out.println("clientSocket = " + clientSocket);

        System.out.println("Incoming connection from " + clientSocket.getInetAddress().getHostAddress());

        BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);

        String inputLine;
        while ((inputLine = inputFromClient.readLine()) != null) {
            System.out.println("Received message: " + inputLine + " from " + clientSocket.toString());
            outputToClient.println("Message received loud and clear");
        }
    }
}
