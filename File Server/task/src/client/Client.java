package client;

import java.net.InetAddress;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;

public class Client {


     void start() throws IOException {
         String address = "127.0.0.1";
         int port = 1024;
         Socket socket = new Socket(InetAddress.getByName(address), port);
         DataOutputStream DataOS = new DataOutputStream(socket.getOutputStream());
         DataInputStream DataIS = new DataInputStream(socket.getInputStream());

    }
}
