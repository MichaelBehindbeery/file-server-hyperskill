package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Command extends Thread{

    Scanner scanner = new Scanner(System.in);
    public Command(DataOutputStream outputStream) throws Exception{
        run(outputStream);
    }

    public void run(DataOutputStream output) throws IOException {
        String command = scanner.next();
        Client.sendMSG(output ,command);
    }
}
