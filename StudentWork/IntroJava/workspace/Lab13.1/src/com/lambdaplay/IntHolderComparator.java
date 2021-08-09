/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.lambdaplay;

import java.util.Comparator;


public class IntHolderComparator implements Comparator<IntHolder> {

    public int compare(IntHolder a, IntHolder b) {
        return a.getVal()-b.getVal(); }
}
