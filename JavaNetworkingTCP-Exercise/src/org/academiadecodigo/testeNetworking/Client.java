package org.academiadecodigo.testeNetworking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        String message;

        //Open a client socket to localhost on port 55000
        Socket clientSocket = new Socket("127.0.0.1", 55000);

        //create the out stream
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        //scan the input
        do
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a message: ");

            //read the message
            message = scanner.nextLine();

            out.println(message);
            out.flush();

        //message is not equal to "exit"
        }while (!message.equals("exit"));

    }
}


