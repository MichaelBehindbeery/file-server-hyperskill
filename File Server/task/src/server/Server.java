package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    void start() throws IOException {
        String address = "127.0.0.1";
        int port = 1024;
        ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address));
        Socket socket = server.accept();
        DataOutputStream DataOS = new DataOutputStream(socket.getOutputStream());
        DataInputStream DataIS = new DataInputStream(socket.getInputStream());

    }

}
