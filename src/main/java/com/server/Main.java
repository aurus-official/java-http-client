package com.server;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Reading bytes from a file");
            Path pathToMessage = Paths.get("/home/russ/Programming/java-http-server/src/main/resources/message.txt");
            File messageFile = pathToMessage.toFile();
            FileInputStream fis = new FileInputStream(messageFile);

            byte[] byteToBeRead = new byte[8];
            StringBuilder strbLine = new StringBuilder();
            

            while (fis.read(byteToBeRead) != -1) {
                
                StringBuilder bytesOf8Strb = new StringBuilder(new String(byteToBeRead));
                
                int indexOfNextLine = bytesOf8Strb.toString().indexOf("\n");
                
                if (indexOfNextLine == -1) {
                    strbLine.append(bytesOf8Strb.toString());
                    continue;
                }

                while (true) {
                    strbLine.append(bytesOf8Strb.substring(0, indexOfNextLine + 1));
                    System.out.print(strbLine.toString());
                    strbLine = new StringBuilder();
                    bytesOf8Strb.delete(0, indexOfNextLine + 1);

                    indexOfNextLine = bytesOf8Strb.toString().indexOf("\n");

                    if (indexOfNextLine == -1) {
                        strbLine.append(bytesOf8Strb.substring(0));
                        break;
                    }
                }

            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
