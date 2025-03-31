package com.Streamer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class StreamerServer {

  ServerSocket serverSocket;
  Socket clientSocket;

  StreamerServer(int portNo,String folder, String filename) {
    try {
      serverSocket = new ServerSocket(portNo);
      serverService(folder, filename);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void serverService(String folder, String filename){
    File folderHandle = new File(folder);    
    if (folderHandle.exists())
    {
      System.out.println("Folder exists");
      boolean running = true;      
      
      while (running) {                
        
        
        
        try
        {
          System.out.println("Awaiting Connection");
          clientSocket = serverSocket.accept();
          System.out.println("Connection detected");

          BufferedImage image = ImageIO.read(clientSocket.getInputStream());
          System.out.println("\tFile read");
          File outputfile = new File(folder + "\\" + filename);
          ImageIO.write(image, "png",outputfile);          
          System.out.println("\tFile saved");
          
        } catch (IOException e) {
          System.out.println("bollocks");
          throw new RuntimeException(e);
        }         
      }     
    
      System.out.println("Closing server");
      close();
    
    }
    else{
      System.out.println("Folder doesn't exist");
    }
  }

  public void close() {
    try {
      serverSocket.close();
      clientSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void awaitConnection() {
    try {
      clientSocket = serverSocket.accept();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getMessage() {
    String message = "";
    try {
      System.out.println("waiting msg");
      InputStream in = clientSocket.getInputStream();
      byte[] content = in.readAllBytes();
      message = new String(content);

      System.out.println();
      // OutputStream out = clientSocket.getOutputStream();
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return message;
  }

  public void streamerService() {
    boolean running = true;
    while (running) {
      awaitConnection();                  
      running = processMessage(getMessage());      
    }

  }

  public boolean processMessage(String message){    
    if (message.equals("END")){
      System.out.println("Shutdown message received..");      
      return false;
    }
    return true;
  }

}
