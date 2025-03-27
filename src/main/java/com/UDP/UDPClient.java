package com.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPClient {

  InetAddress address;
  DatagramSocket datagramSocket;
  byte[] buffer = new byte[65508];
  int portNo;

  UDPClient(int portNo){
    try {
      address = InetAddress.getLocalHost();
      datagramSocket = new DatagramSocket();
      this.portNo=portNo;

    } catch (IOException e) {
      
      e.printStackTrace();
    }
  }

  public void close(){
    datagramSocket.close();
  }

  public void sendMessage(String message){
    buffer = message.getBytes();
    
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, portNo);

    try {
      datagramSocket.send(packet);
    } catch (IOException e) {      
      e.printStackTrace();
    }
  }

}
