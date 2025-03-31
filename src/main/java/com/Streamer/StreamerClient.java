package com.Streamer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class StreamerClient {
  Socket toServer;
  String serverSocket;
  int portNo;

  StreamerClient(String serverSocket, int portNo, String folder, String filename){
    this.serverSocket = serverSocket;
    this.portNo = portNo;
    clientService(folder, filename);
  }

  public void clientService(String folder, String filename){
    File folderHandle = new File(folder);
    File fileHandle = new File(folder + "\\" + filename);
    if (folderHandle.exists() && fileHandle.exists())
    {
      boolean running = true;      
      long lastUpload = 0;

      while (running) {                
        if (lastUpload!=fileHandle.lastModified()){
          System.out.println("File change detected");
          try {
            Thread.sleep(1000);
            System.out.println("\tAttempting upload - " +folder + "\\" + filename);
            fileHandle = new File(folder + "\\" + filename);            
            BufferedImage image = ImageIO.read(fileHandle);            
            toServer = new Socket(serverSocket, portNo);
            OutputStream out = toServer.getOutputStream();
            ImageIO.write(image, "png", out);
            out.close();
            
            toServer.close();            
            System.out.println("\tUploaded");
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
          catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        lastUpload = fileHandle.lastModified();
        }    
         
      }
    } else {
      System.out.println("Folder or file does not exist");
    }
  }

  public void connect(String serverSocket, int portNo) {
    try {
      toServer = new Socket(serverSocket, portNo);
    } catch (IOException e) {
      e.printStackTrace();
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
