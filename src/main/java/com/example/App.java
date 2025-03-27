package com.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }


    public static void main(String[] args) {

        

        if (args.length>0){
            System.out.println("args [" + args[0] + "]");
            if (args[0].equals("SERVER")){
                System.out.println("Server started");
                Server server = new Server(9876);
                boolean running = true;
                while (running){
                    server.awaitConnection();
                    System.out.println("Server detected lient connected");
                    running=false;
                    String message = server.getMessage();
                    server.close();
                    System.out.println("Server received message : " + message);
                }
            }
            else {
                
                System.out.println("Client started");
                try {
                    InetAddress host = InetAddress.getLocalHost();
                    Client client = new Client(host.getHostName(), 9876);
                    System.out.println("Client connected");
                    client.sendMessage("Hello Andy");

                    System.out.println("MEssage sent");
    
                    client.close();
                    System.out.println("Client closed");
                } catch (UnknownHostException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                


            }
        }
    }
}
