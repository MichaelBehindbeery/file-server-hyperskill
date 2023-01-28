package client;

import java.net.InetAddress;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static Scanner scanner = new Scanner(System.in);

    private static final String IP_ADDRESS = "127.0.0.1";

    private static final int PORT = 1024;

    public static String reciveMSG(DataInputStream input) throws IOException {
        String msg = input.readUTF();
        return msg;
    }

    public static void sendMSG(DataOutputStream output, String msg) throws IOException {
        output.writeUTF(msg);
    }


    public static void start() throws IOException {
            try(Socket socket = new Socket(InetAddress.getByName(IP_ADDRESS) , PORT);
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            ){
                System.out.println("Client started!");
                menu(outputStream , inputStream ,socket);
            } catch (UnknownHostException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
    }

    private static void menu(DataOutputStream output , DataInputStream input , Socket socket) throws Exception {
        System.out.println("Enter action (1 - get a file, 2 - create a file, 3 - delete a file): ");;
        String command = scanner.next();
        switch (command){
            case "2":
                sendMSG(output , "PUT");
                putFile(output,input);
                break;
            case "3":
                sendMSG(output, "DELETE");
                deleteFile(output,input);
                break;


        }
    }

    private static void putFile(DataOutputStream output, DataInputStream input ) throws Exception{
        System.out.print("Enter filename: ");
        new Command(output).join();

        System.out.print("Enter file content: ");
        new Command(output).join();

        System.out.println("The request was sent.");

        String statusCode = reciveMSG(input);
        if(statusCode.equals("403")) {
            System.out.println("The response says that file already exists");
        }else {
            System.out.println("The response says that file was created!");
        }

    }

    private static void deleteFile(DataOutputStream output, DataInputStream input ) throws Exception{
        System.out.print("Enter filename: ");

        new Command(output).join();

        System.out.println("The request was sent.");

        String statusCode = reciveMSG(input);
        if(statusCode.equals("403")) {
            System.out.println("The response says that file doesn't exist");
        }else {
            System.out.println("The response says that the file was successfully deleted!");
        }

    }

}
