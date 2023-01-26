package client;

import java.net.InetAddress;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;

public class Client {

    private static final String IP_ADDRESS = "127.0.0.1";

    private static final int PORT = 1024;

    private static void reciveMSG(DataInputStream input) throws IOException {
        String msg = input.readUTF();
        System.out.println("Received: " + msg);
    }

    private static void sendMSG(DataOutputStream output, String msg) throws IOException {
        output.writeUTF(msg);
        System.out.println("Sent: " + msg);
    }


    public static void start() throws IOException {
            try(Socket socket = new Socket(InetAddress.getByName(IP_ADDRESS) , PORT);
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            ){
                System.out.println("Client started!");
                sendMSG(outputStream, "Give me everything you have!");
                reciveMSG(inputStream);
            } catch (UnknownHostException e) {
                System.err.println(e.getMessage());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
    }

}
