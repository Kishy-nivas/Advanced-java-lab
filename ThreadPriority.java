public class ThreadPriority extends Thread {
   public ThreadPriority(String name){
      super(name);

   }

 public void run() {

   String tName = Thread.currentThread().getName();
   Integer tPrio = Thread.currentThread().getPriority();
	 
   System.out.println(tName + " has priority " + tPrio);
 }



 public static void main(String[] args) 
                      throws InterruptedException {

   ThreadPriority t0 = new ThreadPriority("first ");
   ThreadPriority t1 = new ThreadPriority("second ");
   ThreadPriority t2 = new ThreadPriority("third");

   t1.setPriority(Thread.MAX_PRIORITY);	
   t0.setPriority(Thread.MIN_PRIORITY);	
   t2.setPriority(Thread.NORM_PRIORITY);	
  
   t0.start();
   t1.start();
   t2.start();
   
 }
}