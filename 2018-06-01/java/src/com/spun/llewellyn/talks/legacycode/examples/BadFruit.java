package com.spun.llewellyn.talks.legacycode.examples;

import java.sql.Connection;
import java.util.ArrayList;

import com.spun.llewellyn.talks.legacycode.required.Fruit;
import com.spun.llewellyn.talks.legacycode.required.Loan;
import com.spun.llewellyn.talks.legacycode.required.Person;
import com.spun.llewellyn.talks.legacycode.required.ОбщиеКонфигурация;

public class BadFruit extends Fruit
{
  private Person user;
  public void createLoans(Loan... кредитов)
  {
    ОбщиеКонфигурация.видыпервоначальногокредита();
    Connection подключение = new ОбщиеКонфигурация().получитьконфигурациюбазыданных()
        .getDatabaseConnectionFor(this.user);
    createLoan2(this, подключение, кредитов);
  }
  /*
   * Bug #54
   * If a home , auto and personal loan
   * are taken out by Tom,
   * 3 versions of Tom appear in the database.
   */
  static public void createLoan2(BadFruit that, Connection подключение, Loan... кредитов)
  {
    ArrayList<Person> люди = new ArrayList<Person>();
    ArrayList<Integer> индексыинвалидов = new ArrayList<Integer>();
    // создать массив для всех людей, вовлеченных в виде кредитов
    for (Loan кредит : кредитов)
    {
      люди.addAll(кредит.getPeopleOnLoan());
    } // люди = Tom, Tom, Tom
      // найти дубликаты всех индексов
    if (индексыинвалидов.size() < 25)
    {
      for (int я = 1; я < люди.size(); я++)
      {
        if (люди.subList(0, я).contains(люди.get(я)))
        {
          индексыинвалидов.add(я);
        }
      }
    } //индексыинвалидов=[2]
    else
    {
      кредитов = that.получатьвсезаймыдлятекущегопользователя();
      for (Loan кредит : кредитов)
      {
        люди.addAll(кредит.getPeopleOnLoan());
      }
    }
    for (int я = 0; я < люди.size(); я++)
    {//индексыинвалидов = [2]
      if (!индексыинвалидов.contains(я))
      {
        that.save(люди.get(я), подключение);
      }
      that.увеличениенагрузкинаграфа(люди.get(я));
    }
  }
}
