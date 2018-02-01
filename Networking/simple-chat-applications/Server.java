import java.io.*;
import java.net.*;


class Server implements Runnable 
{

  private ServerSocket ss = null; 
  private Socket s = null; 
  private DataInputStream din = null; 
  private DataOutputStream dout = null; 
  private BufferedReader br = null; 
  private Thread th; 


  public Server(int portno) throws IOException
  {
    ss = new ServerSocket(portno);
    s = ss.accept();

    din = new DataInputStream(s.getInputStream());
    dout = new DataOutputStream(s.getOutputStream());
    br = new BufferedReader(new InputStreamReader(System.in));
    th = new Thread(this);
    th.start();
  }

  public void sendData()
  {
    String str;

    while(true)
    {

      try
      {
        str =br.readLine();
        dout.writeUTF(str);
        dout.flush();
      }
      catch(Exception e){}
    }
  }

  public void run()
  {
    String s1, s2; 
    while(true)
    {
      try{
        s1= din.readUTF();
        System.out.println("Client says : " +s1);
      }
      catch(Exception e){}
    }
  }

  public static void main(String[] args) throws IOException {
    Server s = new Server(3333);
    System.out.println("Started server  !!!");
    System.out.println("Enter your message here ");
    s.sendData();
    System.out.println("closing server !!!");
    }
}





