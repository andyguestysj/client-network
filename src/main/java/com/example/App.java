package com.example;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }


    public static void main(String[] args) {

        System.out.println("args [" + args[0] + "]");

        if (args[0].equals("SERVER")){
            System.out.println("Server started");
            Server server = new Server(9876);
            boolean running = true;
            while (running){
                server.awaitConnection();
                running=false;
                String message = server.getMessage();
                server.close();
                System.out.println("Server received message : " + message);
            }
        }
        else {
            System.out.println("Client started");
            Client client = new Client("10.7.95.32", 9876);

            client.sendMessage("Hello Andy");

            client.close();
            System.out.println("Client closed");
        }

    }
}
