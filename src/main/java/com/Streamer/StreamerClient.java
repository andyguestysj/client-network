package com.Streamer;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class StreamerClient {
  Socket toServer;

  StreamerClient(String serverSocket, int portNo) {
    try {
      toServer = new Socket(serverSocket, portNo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void clientService(){
    boolean running = true;
    Scanner scanner = new Scanner(System.in);

    System.out.println("TEMP, WIND, RAIN, or EXIT");
    String required = scanner.nextLine();

    while (running) {


      
    

    }
  }

  public void close() {
    try {
      toServer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
