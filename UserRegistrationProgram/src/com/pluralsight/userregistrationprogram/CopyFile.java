package com.pluralsight.userregistrationprogram;

import java.io.*;

public class CopyFile {
    public static void CopyFile(File input, File output) throws FileNotFoundException {

        try {
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(output, true);
            String s;

            while ((s = br.readLine()) != null) { // read a line
                fw.append("\n");
                fw.write(s); // write to output file
                fw.flush();
            }
            br.close();
            fw.close();
            System.out.println("file copied");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
