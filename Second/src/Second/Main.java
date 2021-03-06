package Second;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a number: ");
        int num = scanner.nextInt();

        //System.out.println("type a digit to add: ");
        //int digit = scanner.nextInt();

        int maxVal = MaximumPossible(num);
        System.out.println("Maximum Possible Value is : " + maxVal);
    }

    static int MaximumPossible(int num) {

        int digit = 5;

        // edge case
        if (num == 0) {
            return digit * 10;
        }

        // -1 if num is negative number else 1
        int negative = num / Math.abs(num);
        // get the absolute value of given number
        num = Math.abs(num);
        int n = num;
        // maximum number obtained after inserting digit.
        int maxVal = Integer.MIN_VALUE;
        int counter = 0;
        int position = 1;

        // count the number of digits in the given number.
        while (n > 0) {
            counter++;
            n = n / 10;
        }

        // loop to place digit at every possible position in the number,
        // and check the obtained value.
        for (int i = 0; i <= counter; i++) {

            int newVal = ((num / position) * (position * 10)) + (digit * position) + (num % position);

            // if new value is greater the maxVal
            if (newVal * negative > maxVal) {
                maxVal = newVal * negative;
            }

            position = position * 10;
        }
        return maxVal;
    }

}
