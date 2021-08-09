/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.poetry.io;

import java.io.*;
import java.util.stream.Stream;

public class PoemClient {

  /**
   * Uncomment these after you've completed their implementations.
   */
  public static void main(String[] args) throws IOException {
    readPoem();
    writePoem();
    readPoem1();
  }
  
  /**
   * TASK: read all the lines in file 'famous-poem.txt'.
   * Avoid the temptation to open the file in Eclipse first.
   * You'll see the poem once you get your code working(!)
   * 
   * This file is in the project root directory, which is the current / working 
   * directory at runtime.  Therefore, the path to the file is just the filename.
   * 
   * Use a BufferedReader wrapped around a FileReader.
   * Use a try-with-resources to initialize the stream and auto-close it.
   */
  private static void readPoem() {
    try (BufferedReader reader = new BufferedReader(new FileReader("famous-poem.txt"))) {  // TODO: initialize 'reader' variable
      // here is an easy way to dump out all the lines
      // you may not have worked with Java 8 streams, so we give this to you
      Stream<String> lines = reader.lines();
      lines.forEach(System.out::println);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * TASK: write a poem of your own creation to file 'my-poem.txt'.
   * 
   * Use a PrintWriter wrapped around a FileWriter.
   * Use a try-with-resources to initialize the stream and auto-close it.
   */
  private static void writePoem() throws IOException {
    // TODO
    try (PrintWriter out = new PrintWriter(new FileWriter("my-poem.txt"))) {
      out.println("I have nothing to give you, but my anger");
      out.println("And the filaments of my hatred reach across the border");
      out.println("You, you have sold many and me to exile.");
      out.println("Now shorn of precious minds, you rely only on");
      out.println("What hands can grow to build your crumbling image.");
      out.println("Your streets are littered with handcuffed men");
      out.println("And the drums are thuds of the wardens' spiked boots.");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void readPoem1() {
    try (BufferedReader reader = new BufferedReader(new FileReader("my-poem.txt"))) {  // TODO: initialize 'reader' variable
      // here is an easy way to dump out all the lines
      // you may not have worked with Java 8 streams, so we give this to you
      Stream<String> lines = reader.lines();
      lines.forEach(System.out::println);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}