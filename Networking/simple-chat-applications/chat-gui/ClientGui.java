import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.net.*;

class Gui2 implements Runnable, ActionListener 
{
  private JFrame frame; 
  private JTextField tf; 
  private JButton btn ;
  private JTextArea ta; 
  private Socket s = null;
  private PrintWriter pw =null ; 
  private BufferedReader br =null ; 
  private Thread th;

  
  public Gui2()
  {
    frame = new JFrame("Client ");
    frame.setLayout(new FlowLayout(FlowLayout.CENTER));  
    frame.setSize(500,300);
    btn = new JButton("send");
    tf = new JTextField(15);
    ta = new JTextArea(12,25);
    ta.setEditable(false);
    
    //actions 
    btn.addActionListener(this);

    //add buttons 

    frame.add(tf);
    frame.add(btn);
    frame.add(ta);
    frame.setVisible(true);

    try
    {
      s = new Socket("localhost",3333);
      br = new BufferedReader(new InputStreamReader(s.getInputStream()));
      pw = new PrintWriter(s.getOutputStream(),true);

    }
    catch(Exception e){}

    // Thread 
    th = new Thread(this);
    th.setDaemon(true);
    th.start();
  }

  public void actionPerformed(ActionEvent e)
  {
    pw.println(tf.getText());
    tf.setText("");
  }

  public void run()
  {
    while(true)
    {
      try{
        ta.append(br.readLine() +"\n");
      }
      catch(Exception e){}
    }
  }


}

public class ClientGui
{
  public static void main(String[] args) {
    Gui2 g = new Gui2();

  }

}

