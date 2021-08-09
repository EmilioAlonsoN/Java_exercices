/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package gov.irs;

/* 
 * class IRS: Simple class that holds TaxPayer (an interface) instances
 * and can collect taxes from them.  Designed to illustrate use of interfaces.
 * 
 */

import java.util.ArrayList;
import java.util.Collection;

public class IRS {
  // INSTANCE VARIABLES
  //private TaxPayer[] payers = new TaxPayer[100];
  private Collection<TaxPayer> taxPayers = new ArrayList<>(100);
  private int currentIndex = 0;  // for dealing with array
  
  // BEHAVIORAL METHODS
  public void collectTaxes() {
    for (TaxPayer current : taxPayers) {
      current.payTaxes();
    }
  }

  public void getStandardDeductions() {
    for (TaxPayer current : taxPayers) {
      System.out.println("Standard Deduction: " + current.getStandardDeductions());
    }

  }
  
  // helper method to add a Taxpayer to the array
  public void register(TaxPayer payer) {
    taxPayers.add(payer);
  }
}