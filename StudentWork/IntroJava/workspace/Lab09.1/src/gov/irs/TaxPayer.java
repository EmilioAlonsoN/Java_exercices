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
 * TaxPayer is our simple interface for working with interfaces.
 */

public interface TaxPayer {
  public void payTaxes();
  public default double getStandardDeductions() {
    return 7500.00;
  }
}