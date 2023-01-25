package server;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }
}
        /*
        boolean terminate = false;
        List<String> files = new ArrayList();
        Scanner sc = new Scanner(System.in);
        while (!terminate){
            String fileName;
            String command = sc.next();
                    fileName = sc.next();
            switch (command){
                case "add":
                    if(files.size() < 10 && !files.contains(fileName) && fileName.matches("^file([1-9]|10)$")){
                        System.out.println("The file " + fileName + " added successfully ");
                        files.add(fileName);
                    }
                    else{
                        System.out.println("Cannot add the file " + fileName );
                    }
                    break;
                case "get":
                    fileName = sc.next();
                    if(files.contains(fileName)){
                        System.out.println("The file " + fileName  + " was sent" );
                    }
                    else{
                        System.out.println("The file " + fileName  + " not found\n");
                    }
                    break;
                case "delete":
                    fileName = sc.next();
                    if(files.contains(fileName)){
                        System.out.println("The file " + fileName.toLowerCase()  + " was deleted" );
                        files.remove(fileName);
                    }
                    else{
                        System.out.println("The file " + fileName.toLowerCase()  + " not found");
                    }
                    break;
                case "exit":
                    terminate = true;
                    break;

            }
        }
         */
