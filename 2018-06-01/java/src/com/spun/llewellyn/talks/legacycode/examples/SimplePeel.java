package com.spun.llewellyn.talks.legacycode.examples;

import java.sql.Connection;

import com.spun.llewellyn.talks.legacycode.required.Person;

public class SimplePeel
{
  public double calculateTotalMortgage(String name, Connection con)
  {
    Person p = Person.loadPersonByName(name, con);
    Double homeEquityLoan = p.getFinancalInformation().getHomeEquityLoan();
    Double firstMortagePayment = p.getFinancalInformation().getFirstMortagePayment();
    return calculateMortgage2(homeEquityLoan, firstMortagePayment);
  }
  public double calculateMortgage2(Double homeEquityLoan, Double firstMortagePayment)
  {
    double total = 0.00;
    if (homeEquityLoan != null)
    {
      total = homeEquityLoan + firstMortagePayment;
    }
    else if (firstMortagePayment != null)
    {
      total = firstMortagePayment;
    }
    return total;
  }
}