import java.io.*;
import java.net.*;


class Client implements Runnable  
{

  private Socket s = null; 
  private DataInputStream din = null; 
  private DataOutputStream dout = null; 
  private BufferedReader br = null;
  private Thread th;  

  public Client(int portno) throws IOException 
  {
    s= new Socket("localhost",3333);

    din = new DataInputStream(s.getInputStream());
    dout = new DataOutputStream(s.getOutputStream());
    br = new BufferedReader(new InputStreamReader(System.in));
    th = new Thread(this);
    th.start();
  }

  public void sendData()
  {
    String s1; 
    while(true)
    {
      try
      {
        s1= br.readLine();
        dout.writeUTF(s1);
        dout.flush();
      }
      catch(Exception e){}
    

    }
  }

  public void run()
  {
    String s1; 
    while(true)
    {
      try{
        s1 = din.readUTF();
        System.out.println("Server says : " + s1);
      }
      catch(Exception e){}

    }
  }

  public static void main(String[] args) throws IOException {
    Client c = new Client(3333);
    System.out.println("connection connected ......");
    System.out.println("Enter your message here");
    c.sendData();
    System.out.println("connection terminated ");  
  }

}



