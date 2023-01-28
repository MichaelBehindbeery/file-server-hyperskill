package server;

import client.Client;

import java.io.*;
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
                clientHandler(socket , inputStream , outputStream);
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

    private static void clientHandler(Socket socket , DataInputStream input , DataOutputStream output) throws IOException {

        while(!socket.isClosed()){
            String commandToExecute = input.readUTF();
            switch (commandToExecute){
                case "PUT":
                    PUT(output,input);
                    break;
                case "DELETE":
                    DELETE(output,input);
                    break;
            }
        }
    }


    private static void PUT(DataOutputStream output , DataInputStream input) throws IOException {
        String fileName = input.readUTF();
        File file = new File("C:\\Users\\micha\\IdeaProjects\\File Server\\File Server\\task\\src\\server\\data\\folder\\" + fileName);
        if(file.exists()) {
            output.writeUTF("403");
        }else {
            String fileContent = input.readUTF();
            try(PrintWriter fileWriter = new PrintWriter(file)){
                fileWriter.print(fileContent);
            }catch (IOException e){
                e.printStackTrace();
            }
            output.writeUTF("200");
        }
    }

    private static void DELETE(DataOutputStream output , DataInputStream input) throws IOException {
        String fileName = input.readUTF();
        File file = new File("C:\\Users\\micha\\IdeaProjects\\File Server\\File Server\\task\\src\\server\\data\\folder\\" + fileName);
        if(!file.exists()) {
            output.writeUTF("404");
        }else {
            file.delete();
            output.writeUTF("200");
        }
    }





}
