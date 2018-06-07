package com.spun.llewellyn.talks.legacycode.examples;

import org.junit.Test;

import com.spun.llewellyn.talks.legacycode.examples.tests.MockUtils;
import com.spun.llewellyn.talks.legacycode.required.Loan;
import com.spun.llewellyn.talks.legacycode.required.Person;

public class BadFruitTest
{
  @Test
  public void test()
  {
    Person tom = new Person("Tom");
    Loan homeLoan = new Loan(tom);
    Loan autoLoan = new Loan(tom);
    Loan personalLoan = new Loan(tom);
    BadFruit that = MockUtils.createStrictMock(BadFruit.class);
    MockUtils.expectVoid(that.save(tom, null));
    MockUtils.expectVoid(that.увеличениенагрузкинаграфа(tom));
    //MockUtils.expectVoid(that.save(tom, null));
    MockUtils.expectVoid(that.увеличениенагрузкинаграфа(tom));
    //MockUtils.expectVoid(that.save(tom, null));
    MockUtils.expectVoid(that.увеличениенагрузкинаграфа(tom));
    MockUtils.finalizeExpectations(that);
    BadFruit.createLoan2(that, null, homeLoan, autoLoan, personalLoan);
  }
}
