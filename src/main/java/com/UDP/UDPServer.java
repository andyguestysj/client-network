package com.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
  
  DatagramSocket datagramSocket;
  byte[] buffer = new byte[65508];
  int portNo;


  UDPServer(int portNo){
    this.portNo = portNo;
    try {
      datagramSocket = new DatagramSocket(portNo);
    } catch (SocketException e) {
      
      e.printStackTrace();
    }
  }

  public void close(){
    datagramSocket.close();
  }

  public String awaitMessage(){

    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    try {
      datagramSocket.receive(packet);
      String received = new String(packet.getData(), 0, packet.getLength());
      return received;

    } catch (IOException e) {
      
      e.printStackTrace();
    }

    return "";
  }


}
