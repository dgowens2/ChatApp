package com.tiy.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by DTG2 on 08/25/16.
 */
public class ChatAppClient {
    public static void main(String[] args) {
        System.out.println("Test...");

        try {

            Socket clientSocket = new Socket("10.0.0.7", 8585);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            out.println("Hello from the other side...");
            String serverResponse = in.readLine();

            clientSocket.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
