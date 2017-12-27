class CalculateRange extends Thread 
{
  public int from ,to,sum;

  public CalculateRange(int from , int to )
  {
    this.from = from;
    this.to = to;
    sum= 0; 
  }

 
  public void run()
  {
    for (int i= this.from ; i<=this.to ; i++ )
    {
      sum+=i;

    }
  }

  public int getSum() 
  {
    return sum;
  }

}

public class MultithreadingExample 
{
    public static void main(String[] args)
  {
    CalculateRange calc1 = new CalculateRange(1,5);
    CalculateRange calc2 = new CalculateRange(5,10);
    calc1.start();
    calc2.start();

    try
    {
      calc1.join();
      calc2.join();

    }
    catch(InterruptedException e)
    {
      e.printStackTrace();
    }
   
    System.out.println("Total sum : " +  (calc1.getSum() + calc2.getSum()));

  }


}


