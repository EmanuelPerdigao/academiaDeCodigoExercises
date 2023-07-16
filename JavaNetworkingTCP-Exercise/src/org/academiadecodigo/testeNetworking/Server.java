package org.academiadecodigo.testeNetworking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Server
{
    public static void main(String[] args) throws IOException {

        String message = "";

        //Open a client socket to localhost on port 55000
        ServerSocket serverSocket = new ServerSocket(55000);

        //wait for a client to connect
        Socket clientSocket = serverSocket.accept();
        System.out.println(clientSocket + " connected!");

        //create the input stream
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //scan the input
        do
        {
            message = in.readLine();
            System.out.println(message);

        //message is not equal to "exit"
        }while (!message.equals("exit"));

        //close sockets
        clientSocket.close();
        serverSocket.close();

    }
}
