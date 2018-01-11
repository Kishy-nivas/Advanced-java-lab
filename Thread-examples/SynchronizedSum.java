import java.io.*;
import java.util.*;

class Update
{
  public void UpdateSum(int n )
  {
    synchronized(this)
    {
      Thread t = Thread.currentThread();
      for(int i= 0;i<n;i++)
      {
        System.out.println(t.getName() +": " +  i);
      }
    }

  }
}



class A extends Thread 
{
  Update u = new Update();
  public void run()
  {
    u.UpdateSum(10);

  }
}

public class SynchronizedSum
{
  public static void main(String[] args)
  {
    A a = new A();

    Thread t1 = new Thread(a);
    Thread t2 = new Thread(a);
    t1.start();
    t2.start();


  }
}