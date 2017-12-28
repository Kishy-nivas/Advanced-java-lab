import java.util.*;
 class Print
 {
  public synchronized void print(int thread_no, int n)
  {

    
    try
    { 
      
      Thread.sleep(1000);
      System.out.println("Thread no is  : " + thread_no + " return value : " + n);
    }
    catch(InterruptedException e)
    {
      System.out.println("Exception occured ");

    }
  }
 }

 class AverageNumber implements Runnable
{
  int n;
  private int[] num;
  double avg;
  Print p = new Print() ; 
  public AverageNumber(int[] num)
  {
    this.num = num;
  }
  public void run()
  {

    for(int i = 1; i < num.length-1; i++)
    {
    n = n+num[i];
    avg = (double)n/i;
    }
    p.print(1,(int)avg);


  }
}


class MaximumNumber implements Runnable
{
  private int[] number;
  Print p = new Print(); 
  public MaximumNumber(int[] number)
  {
    this.number = number;
  }
  public void run()
  {
    int largest = number[0];
    for(int i=1; i< number.length; i++)
    {
      if(number[i] > largest)
        largest = number[i]; 
    }
    p.print(2,largest);
  }
}


class MinimumNumber implements Runnable
{
  private int[] nmb;
  Print p = new Print();
  public MinimumNumber(int[] nmb)
  {
  this.nmb = nmb;
  }
  public void run()
  {
  int smallest = nmb[0];
  for(int i=1; i< nmb.length-1; i++)
  {
    if (nmb[i] < smallest)
    smallest = nmb[i]; 
  }
  p.print(3,smallest);
 

  }
}
public class SynchronizationDemo2
{

  public static void main(String [] args)
  {
   
    int n;
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the array size");
    n= sc.nextInt();
     int[] numarr = new int[n];
    for(int i=0; i<n; i++)
    {
      numarr[i] = sc.nextInt();
    }
    Runnable hello = new AverageNumber(numarr);
    Thread thread1 = new Thread(hello);
    thread1.setName("AvgNum");
    System.out.println(thread1.getName() + " is starting...");
    thread1.start();

    Runnable bye = new MaximumNumber(numarr);
    Thread thread2 = new Thread(bye);
    thread2.setName("MaxNum");
    System.out.println(thread2.getName() + " is starting...");
    thread2.start();

    Runnable min = new MinimumNumber(numarr);
    Thread thread3 = new Thread(min);
    thread3.setName("MinNum");
    System.out.println(thread3.getName() + " is starting...");
    thread3.start(); 
  }
}


