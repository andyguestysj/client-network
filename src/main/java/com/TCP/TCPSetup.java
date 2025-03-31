package com.TCP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TCPSetup {

  public TCPSetup(boolean isServer, int portNo) {

    if (isServer) {
      System.out.println("TCP Server started");
      TCPServer server = new TCPServer(portNo);
      boolean running = true;
      while (running) {
        server.awaitConnection();
        System.out.println("Server detected client connected");
        running = false;
        String message = server.getMessage();
        server.close();
        System.out.println("Server received message : " + message);
      }
    } else {
      System.out.println("TCP Client started");
      try {
        InetAddress host = InetAddress.getLocalHost();
        TCPClient client = new TCPClient(host.getHostName(), portNo);
        System.out.println("Client connected");
        String aMessage = "Hello Andy";
        client.sendMessage(aMessage);

        System.out.println("Message sent \"" + aMessage + "\"");

        client.close();
        System.out.println("Client closed");
      } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}
