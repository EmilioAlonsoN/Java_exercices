/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.data.io;

import java.io.*;

public class PersonDataClient {

  /**
   * Uncomment these after you've completed their implementations.
   */
  public static void main(String[] args) throws IOException {
    myWriteData();
    writeData();
    readData();
  }
  
  /**
   * TASK: write the following data (as Strings and Java primitives) to file 'person.dat':
   * your-name (String)  your-age (int)  your-shoe-size (double)  marital-status (boolean)
   * 
   * Here's a sample:
   * Java Programmer     51              9.5                      true
   * 
   * Use a DataOutputStream wrapped around a FileOutputStream.
   * Use a try-with-resources to initialize the stream and auto-close it.
   */
  private static void writeData() {
    // TODO
    try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("person.dat"))) {
      outputStream.writeUTF("Emilio Alonso");
      outputStream.writeInt(40);
      outputStream.writeDouble(9.5);
      outputStream.writeBoolean(true);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void myWriteData() throws IOException {
    try {
      FileWriter writer = new FileWriter("person.txt", true);
      String name = "Emilio Alonso";
      Integer age = 40;
      double shoeSize = 9.5;
      boolean maritalStatus = true;
      BufferedWriter bw = new BufferedWriter(writer);
      bw.write(String.format("Your name is: %s Your age is: %d Your shoe size is: %f Marital status is: %b", name, age, shoeSize, maritalStatus));
      bw.append("\n");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * TASK: read the data written to 'person.dat' back in to the appropriate Java datatypes.
   * 
   * You need to read it in the same sequence as it was written.
   * Then print to stdout to see it.
   * 
   * Use a DataInputStream wrapped around a FileInputStream.
   * Use a try-with-resources to initialize the stream and auto-close it.
   */
  private static void readData() throws IOException {
    // TODO
    try (DataInputStream inputStream = new DataInputStream(new FileInputStream("person.dat"))) {
      String name = inputStream.readUTF();
      Integer age = inputStream.readInt();
      double shoeSize = inputStream.readDouble();
      boolean maritalStatus = inputStream.readBoolean();

      System.out.println("Your name is: " + name + ", Your age is: " + age + ", Your shoe size is: " + shoeSize + ", Marital status is: " + maritalStatus);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}