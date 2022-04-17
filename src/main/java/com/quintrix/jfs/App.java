package com.quintrix.jfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    // Variables
    String hw = "Hello World!";
    String myName = "Dustin Jones";
    String fileName = "helloWorld.txt";
    String divider = "****************************************\n";
    String writeHead = divider + "* Writing to file\n" + divider;
    String readHead = divider + "* Reading from file\n" + divider;

    // Output hello word and name
    System.out.println(hw);
    System.out.println(myName);
    System.out.println();

    // Begin write process
    // Output head
    System.out.println(writeHead);

    // Attempt write
    try {
      FileWriter writer = new FileWriter(fileName);

      writer.write(hw + " from " + myName);
      writer.close();

      System.out.println(" - Successfully executed \'write\' process\n\n");

    } catch (IOException e) {
      System.out.println("Error with \'write\' process");
    }

    // Begin read process
    // Output head
    System.out.println(readHead);

    // Attempt read process
    try {
      File myFile = new File(fileName);
      Scanner fileReader = new Scanner(myFile);
      System.out.println(" - File contents: \n");

      while (fileReader.hasNextLine()) {
        System.out.println(fileReader.nextLine());
      }

      fileReader.close();
      System.out.println("\n - Successfully executed \'read\' process");

    } catch (FileNotFoundException e) {
      System.out.println("Error with \'read\' process");
    }
  }
}
