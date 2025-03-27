package com.UDP;

public class UDPSetup {

  public UDPSetup(boolean isServer, int portNo) {

    if (isServer) {
      System.out.println("UDP Server started");
      UDPServer server = new UDPServer(portNo);

      System.out.println("Waiting for message");
      String aMessage = server.awaitMessage();

      System.out.println("Received.. \"" + aMessage + "\"");


      System.out.println("Closing UDP Server");

    }else {
      System.out.println("UDP Client started");
      UDPClient client = new UDPClient(portNo);
      
      String aMessage = "Here is my message";
      System.out.println("Sending.. \"" + aMessage + "\"");
      client.sendMessage(aMessage);

       
      System.out.println("Closing UDP Client");
      client.close();
    }
  }
}