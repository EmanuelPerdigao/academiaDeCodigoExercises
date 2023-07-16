package org.academiadecodigo.testeNetworking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) throws IOException {

        // STEP2: Open a client socket, blocking while connecting to the server
        Socket clientSocket = new Socket("127.0.0.1", 8085);


        //Create the threadPool
        ExecutorService fixedPool = Executors.newFixedThreadPool(1);
        //Create the client Worker
        ClientWorker clientWorker = new ClientWorker(clientSocket);
        //Start the thread pool with the "thread" class, clientWorker
        fixedPool.submit(clientWorker);

        //Create the output stream with the clientSocket
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);


        while (true) {
            //Scan the input message
            Scanner scanner = new Scanner(System.in);

            //System.out.print("Enter a message: ");

            //read it
            String message = scanner.nextLine();

            //send it to the server
            out.println(message);
        }
    }

    //Create the Thread Class
    public static class ClientWorker implements Runnable {


        private Socket clientSocket;
        private String word;

        public ClientWorker(Socket clientSocket)
        {
            this.clientSocket = clientSocket;
            word = "";
        }

        @Override
        public void run()
        {

            while (true)
            {
                try {

                    //create the input stream with the client socket
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    //read the message
                    while ((word = in.readLine()) != null)
                    {
                        //print it to the console
                        System.out.println(word);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }
}



