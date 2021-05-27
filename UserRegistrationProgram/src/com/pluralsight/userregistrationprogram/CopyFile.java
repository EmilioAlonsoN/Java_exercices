package com.pluralsight.userregistrationprogram;

import java.io.*;

public class CopyFile {
    // Non use class make copy of a file
    public static void CopyFile(File input, File output) throws FileNotFoundException {

        try {
            FileReader fileReader = new FileReader(input);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(output, true);
            String s;

            while ((s = bufferedReader.readLine()) != null) { // read a line
                fileWriter.append("\n");
                fileWriter.write(s); // write to output file
                fileWriter.flush();
            }
            bufferedReader.close();
            fileWriter.close();
            System.out.println("file copied");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
