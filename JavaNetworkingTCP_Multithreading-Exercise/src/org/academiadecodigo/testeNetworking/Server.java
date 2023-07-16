package org.academiadecodigo.testeNetworking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static LinkedList<PrintWriter> myOutputStreams = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        Server server = new Server();

        // STEP2: Open a client socket, blocking while connecting to the server
        ServerSocket serverSocket = new ServerSocket(8085);

        while (true)
        {

            //Waiting for someone to connect
            Socket clientSocket = serverSocket.accept();

            //sout the client connected
            System.out.println(clientSocket);

            //if someone connected create a new outputstream
            PrintWriter newOutPutStream = new PrintWriter(clientSocket.getOutputStream(), true);

            //Store it inside the list
            myOutputStreams.offer(newOutPutStream);

            //Create the threadPool
            ExecutorService cachedPool = Executors.newCachedThreadPool();


            //Create the serverHelper thread
           ServerHelper serverHelper = new ServerHelper(clientSocket);

            //Start the thread pool with the "thread" class, serverHelper
            cachedPool.submit(serverHelper);
        }
    }
}
    //Create the Thread Class
    class ServerHelper implements Runnable
    {
        private Socket clientSocket;

        public ServerHelper(Socket clientSocket)
        {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run()
        {
            BufferedReader in;
            String word;

            try {

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                while (true)
                {
                    try
                    {
                        if ((word = in.readLine()) != null)
                        {
                            System.out.println(word);
                        }

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }

        }
    }




