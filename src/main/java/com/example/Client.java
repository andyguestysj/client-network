package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

  Socket toServer;

  Client(String serverSocket, int portNo){
    try {
      toServer = new Socket(serverSocket, portNo);
    } catch (IOException e) {      
      e.printStackTrace();
    }
  }

  public void close(){
    try {
      toServer.close();
    } catch (IOException e) {      
      e.printStackTrace();
    }
  }

  public void sendMessage(String message){
    System.out.println("sending msg");
    try (OutputStream out = toServer.getOutputStream()){
      out.write(message.getBytes());      
      out.flush();
      out.close();
    } catch (IOException e) {
      
      e.printStackTrace();
    }    
  }

  public void getMessage(String message){
    try (InputStream in = toServer.getInputStream()){
      int data = in.read();      
      in.close();
    } catch (IOException e) {      
      e.printStackTrace();
    }    
  }


}
