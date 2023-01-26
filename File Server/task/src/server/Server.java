package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

    private static final String IP_ADDRESS = "127.0.0.1";

    private static final int PORT = 1024;

    static void start() throws IOException {
        try (ServerSocket server = new ServerSocket(PORT, 50, InetAddress.getByName(IP_ADDRESS))) {
            System.out.println("Server started!");

            try (
                    Socket socket = server.accept();
                    DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                    DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            ) {
                reciveMSG(inputStream);
                sendMSG(outputStream, "All files were sent!");
            } catch (UnknownHostException e) {
                System.err.println(e.getMessage());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void reciveMSG(DataInputStream input) throws IOException {
        String msg = input.readUTF();
        System.out.println(msg);
    }

    private static void sendMSG(DataOutputStream output, String msg) throws IOException {
        output.writeUTF(msg);
        System.out.println(msg);
    }

    private static void menu(DataOutputStream output , DataInputStream input , Socket socket) throws IOException{
        sendMSG(output ,"Enter action (1 - get a file, 2 - create a file, 3 - delete a file): ");
        while(!socket.isClosed()){
            sendMSG(output ,"Enter action (1 - get a file, 2 - create a file, 3 - delete a file): ");
            String choice = input.readUTF();
            switch (choice) {
                case "1":

            }
        }
    }

    private static void get(DataOutputStream output, DataInputStream input ) throws IOException{
        sendMSG(output ,"Enter filename: ");
        String fileName = input.readUTF();
        File file = new File("server/data/folder/" + fileName);
        if(!file.exists()){
            sendMSG(output, "404");
        }

    }

}
