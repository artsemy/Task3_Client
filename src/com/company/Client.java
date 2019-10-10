package com.company;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private BufferedReader reader;
    private BufferedReader in;
    private BufferedWriter out;

    //run client
    public void run(){
        try {
            try {
                clientSocket = new Socket("localhost", 4004);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                System.out.println("Client start");
                String serverWord;
                String clientWord = "start";
                while (!clientWord.equals("exit")) {
                    serverWord = in.readLine();
                    System.out.println(serverWord);
                    clientWord = reader.readLine();
                    out.write(clientWord + "\n");
                    out.flush();
                }
            } finally {
                System.out.println("client close");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
