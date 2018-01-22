import java.io.*;
import java.util.*;


class pc 
{
  LinkedList<Integer> LL = new LinkedList<>();
  int capacity = 2; 
  int value = 0; 
  public void produce() throws InterruptedException 
  {
    while(true)
    {
      synchronized(this)
      {
        while(LL.size() == capacity )
          wait();
        System.out.println("Producer produced " + value);
        LL.add(value++);
        notify();


      }
    }

  }

  public void consume() throws InterruptedException
  {
    while(true )
    {
      synchronized(this)
      {
        while(LL.size() == 0)
          wait();

        int val = LL.removeFirst();
        System.out.println("consumer consumed " + val );
        notify();

      }

    }
    

  }

}



class ProducerConsumer 
{
  public static void main(String[] args)
  {
    pc p = new pc();
    Thread t1 = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          p.produce();
        }
        catch(InterruptedException e)
        {

        }
      }

    });

    Thread t2 = new Thread(new Runnable()
      {
        @Override 
        public void run()
        {
          try
          {
            p.consume();
          }
          catch(InterruptedException e)
          {

          }
        }
      });

    t1.start();
    t2.start();
    try
    {
       t1.join();
      t2.join();

    }
    catch(InterruptedException e){ }

  }
}