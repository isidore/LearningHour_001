package com.spun.llewellyn.talks.legacycode.examples;

import org.junit.Test;

import com.spun.llewellyn.talks.legacycode.examples.tests.MockUtils;
import com.spun.llewellyn.talks.legacycode.required.Loan;

public class SimpleSliceTest
{
  @Test
  public void test()
  {
    Loan loan1 = MockUtils.createStrictMock(Loan.class);
    MockUtils.expect(loan1.isOverDue()).andReturn(true);
    MockUtils.expect(loan1.getAmount()).andReturn(60);
    MockUtils.expect(loan1.isOverDue()).andReturn(true);
    MockUtils.expect(loan1.getAmount()).andReturn(60);
    MockUtils.expectVoid(loan1.saveStatus("Escalated", null));
    Loan loan2 = MockUtils.createStrictMock(Loan.class);
    MockUtils.expect(loan2.isOverDue()).andReturn(true);
    MockUtils.expect(loan2.getAmount()).andReturn(6000);
    MockUtils.expectVoid(loan2.saveStatus("Critical", null));
    Loan loan3 = MockUtils.createStrictMock(Loan.class);
    MockUtils.expect(loan3.isOverDue()).andReturn(false);
    MockUtils.expect(loan3.isOverDue()).andReturn(false);
    MockUtils.finalizeExpectations(loan1, loan2, loan3);
    Loan[] loans = {loan1, loan2, loan3};
    new SimpleSlice().escalateProblems(loans, null);
  }
}
