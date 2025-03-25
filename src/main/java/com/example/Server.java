package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  ServerSocket serverSocket;
  Socket clientSocket;

  Server(int portNo){

    try {
      serverSocket = new ServerSocket(portNo);
    } catch (IOException e) {      
      e.printStackTrace();
    }
  }

  public void close(){
    try {
      serverSocket.close();
      clientSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }

  public void awaitConnection(){
    try {
      clientSocket = serverSocket.accept();
    } catch (IOException e) {      
      e.printStackTrace();
    }
  }

  public String getMessage(){
    String message="";
    try {
      InputStream in = clientSocket.getInputStream();
      byte[] content = in.readAllBytes();
      message = new String(content);
                    
      System.out.println();
      //OutputStream out = clientSocket.getOutputStream();
      in.close();
    } catch (IOException e) {      
      e.printStackTrace();
    }  
    return message;
  }

  

}
