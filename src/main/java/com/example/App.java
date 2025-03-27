package com.example;

import com.TCP.TCPSetup;
import com.UDP.UDPSetup;

/**
 * Hello world!
 */
public final class App {
  private App() {
  }

  public static final int PORTNO = 9876;
  public static void main(String[] args) {

    boolean isServer = false;

    System.out.println(args[0] + " " +args[1]);

    if (args.length > 1 && args[1].equals("SERVER")) {
      isServer = true;
    }

    if (args.length > 0 && args[0].equals("TCP")) {
      new TCPSetup(isServer, PORTNO);
    }
    else if (args.length > 0 && args[0].equals("UDP")) {
      new UDPSetup(isServer, PORTNO);
    }

    

    
  }
}
