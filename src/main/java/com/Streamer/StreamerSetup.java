
package com.Streamer;

import java.net.InetAddress;
import java.net.UnknownHostException;



public class StreamerSetup {

  public StreamerSetup(boolean isServer, int portNo) {
    if (isServer) {
      System.out.println("Streamer Server started");
      new StreamerServer(portNo, "ServerFile", "rubbish.png");
    } else {
      System.out.println("Streamer Client started");
      try {
        new StreamerClient(InetAddress.getLocalHost().getHostName(), portNo, "ClientFile", "rubbish.png");
      } catch (UnknownHostException e) {        
        e.printStackTrace();
      }
    }
  }




}
