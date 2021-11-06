package com.company;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the following commands");
        System.out.println("""
                'Create'
                'Write'
                'read'
                'delete'
                'rename'""");
        String input = scanner.next().trim().toLowerCase();
        switch (input) {

            case "Create":
                //Creating File
                try {
                    File myObj = new File("Notes.txt");
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            break;

            case "Write":
                //Writing to file
                try {
                    FileWriter myWriter = new FileWriter("Notes.txt");
                    myWriter.write("Testing writing to file before renaming file");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            break;

            case "Read":
                //Reading file
                try {
                    File myObj = new File("Notes.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            break;

            case "Delete":
                //Delete file
                File myObj = new File("Notes.txt");
                if (myObj.delete()) {
                    System.out.println("Deleted the file: " + myObj.getName());
                } else {
                    System.out.println("Failed to delete the file.");
                }
            break;

            case "Rename":
                //Renaming File
                File sourceFile = new File("Notes.txt");
                File destFile = new File("Keynotes.txt");

                if (sourceFile.renameTo(destFile)) {
                    System.out.println("File renamed successfully");
                } else {
                    System.out.println("Failed to rename file");
                }
                break;
        }

        //Address for home directory
        FileSystemView fileSys = FileSystemView.getFileSystemView();

        File shortcut = fileSys.getHomeDirectory();

        System.out.println(shortcut);
    }


}
