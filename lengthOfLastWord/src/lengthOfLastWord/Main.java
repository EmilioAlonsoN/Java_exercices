package lengthOfLastWord;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a sentece to calculate leght of last word: ");
        String s = scanner.nextLine();
        lengthOfLastWord(s);
    }
    public static int lengthOfLastWord(String s) {
        int len = 0;

        String x = s.trim();

        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ' ')
                len = 0;
            else
                len++;
        }
        System.out.println(len);
        return len;
    }
}
