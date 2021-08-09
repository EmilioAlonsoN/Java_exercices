/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.lambdaplay;

import java.util.ArrayList;

public class LambdaPlay {

    public static void main(String[] args) {
        //runnablePlay();
        //runnableBlockPlay();
        comparatorPlay();
    }

    public static void runnablePlay() {
        // Create a thread, and pass in a normal class that implements Runnable
        Thread thd1 = new Thread(new SimplePrinter());
        thd1.start();


        // Create another Thread, passing in a lambda as its Runnable - then start it
        Thread thd2 = new Thread( () -> System.out.println("simple-lambda") );
        thd2.start();
    }

    public static void runnableBlockPlay() {
        // Create a thread, and pass in a lambda that uses a block
        Thread thd1 = new Thread( () -> {
          for (int i=0; i<10; i++) {
              System.out.println(i);
              try { Thread.sleep (200); }
              catch (InterruptedException e) { e.printStackTrace(); }
          } // end of for loop
        } // end of lambda-block
        ); // end of new Thread()

        thd1.start();
    }

    public static void comparatorPlay() {
        // Create a list of int
        ArrayList<IntHolder> intVals = new ArrayList<IntHolder>();

        intVals.add(new IntHolder(5));
        intVals.add(new IntHolder(3));
        intVals.add(new IntHolder(6));
/*
        // Example of sorting using a regular instance of a Comparator class
        intVals.sort(new IntHolderComparator());
        for (IntHolder cur : intVals) {
            System.out.println(cur.getVal());
        }
*/
        // Sort the list using a lambda as a comparator.
        intVals.sort((a,b) -> a.getVal()-b.getVal());
        for (IntHolder cur : intVals) {
            System.out.println(cur.getVal());
        }
    }
}
