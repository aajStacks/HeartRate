/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartrates;
import java.time.*;
import java.util.Scanner;
//import java.util.ArrayList;//I never used this, initially, I thought I would
//return both values for the Targt Heart Rate using a list but I later managed to do it in
//a simpler way.

/**
 *
 * @author Mohammed Hossain
 */
public class HeartRates {
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private int year;
  private int month;
  private int date;

  public HeartRates(String firstName, String lastName, int month, int date, int year)
  {
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setDOB(month,date,year);
  }

  public void setDOB(int month, int date, int year)
  {
    this.month=month;
    this.date=date;
    this.year=year;
    dateOfBirth=this.month+" "+this.date+" "+this.year;
  }

  public String getDOB()
  {
    return dateOfBirth;
  }

public void setFirstName(String firstName)
{
  this.firstName=firstName;
}

public String getFirstName()
{
  return firstName;
}

public void setLastName(String lastName)
{
  this.lastName=lastName;
}

public String getLastName()
{
  return lastName;
}

  public int ageYears()
  {
      LocalDate birthday = LocalDate.of(year, month, date);
      LocalDate today = LocalDate.now();
      return Period.between(birthday, today).getYears();
  }

public double mhr() //Max Heart Rate Function
{
  int mhrValue=220- ageYears();
  return mhrValue;
}

public double thr1() //Target Heart Rate function left value
{
  double thrValue1=0.5*mhr();
  return thrValue1;
}

public double thr2() //Target Heart Rate function right mhrValue
{
  double thrValue2=0.85*mhr();
  return thrValue2;
}



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner input=new Scanner(System.in);
        HeartRates p1=new HeartRates("John","Smith",02,05,1996);

        System.out.println("Heart Rate Calculator");

        System.out.println("Enter your first name and last name");
        String fn=input.nextLine();
        p1.setFirstName(fn);
        String ln=input.nextLine();
        p1.setLastName(ln);

        System.out.println("Enter your date of birth in dd mm yyyy format (uing spaces)");
        int month=input.nextInt();
        int date=input.nextInt();
        int year=input.nextInt();
        p1.setDOB(month,date,year);

        System.out.println("Heart Rate Calculator");
        System.out.println();
        System.out.printf("%s %s",p1.getFirstName(),p1.getLastName());
        System.out.printf("\n%s %s","DOB",p1.getDOB());
        System.out.println();
        System.out.println("Age "+p1.ageYears());
        System.out.println();
        System.out.println("Max Heart Rate : "+p1.mhr());
        System.out.println();
        System.out.println("Target Heart Rate: ("+p1.thr1()+" , "+p1.thr2()+")");
    }

    }
