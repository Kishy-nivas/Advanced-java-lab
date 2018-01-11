import java.io.*;


class Bank
{
  public int amount=0;
  public int flag=0;

  public void withdraw(int amt )
  {
    synchronized(this)
    {
      if (flag==0)
      {
        try
        {
          System.out.println("waiting.....");
          wait();
        }catch (Exception e) {
          
        }

      }

      System.out.println("withdrawing ");
           amount -=amt;
      System.out.println("current amount : " + amount);
 
    }

  }

  public void deposit(int amt)
  {
    synchronized(this)
    {
      amount += amt;
      System.out.println("deposited ");
      flag =1;
      notifyAll();

    }
  }
}


public class BankExample
{
  public static void main(String[] args)
  {
    Bank b = new Bank();
    Thread t1 = new Thread()
    {
      public void run()
      {
        b.withdraw(1000);

      }

    };


    Thread t2 = new Thread()
    {
      public void run()
      {
        b.deposit(10000);
      }
    };

    t1.start();
    t2.start();
  }

}



