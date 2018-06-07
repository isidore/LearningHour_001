package com.spun.llewellyn.talks.legacycode.examples;

import org.junit.Test;

public class SimplePeelTest
{
  @Test
  public void test()
  {
    new SimplePeel().calculateMortgage2(1.0, 2.0);
    new SimplePeel().calculateMortgage2(null, 2.0);
    new SimplePeel().calculateMortgage2(null, null);
    new SimplePeel().calculateTotalMortgage(null, null);
  }
}
