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
            

            while (fis.read(byteToBeRead) != -1) {
                System.out.println(String.format("Read : %s", new String(byteToBeRead)));

            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
