
package com.Streamer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.TCP.TCPClient;
import com.TCP.TCPServer;

public class StreamerSetup {

  public StreamerSetup(boolean isServer, int portNo) {
    if (isServer) {
      System.out.println("Streamer Server started");
      StreamerServer server = new StreamerServer(portNo);
      server.streamerService();
      server.close();
    } else {
      System.out.println("Streamer Client started");
      try {
        StreamerClient client = new StreamerClient(InetAddress.getLocalHost().getHostName(), portNo);
        client.clientService();
        client.close();
      } catch (UnknownHostException e) {        
        e.printStackTrace();
      }
    }
  }




}
