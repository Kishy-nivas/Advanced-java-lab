import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Watch extends JFrame 
{
  // Gui components 
  private JButton startButton = new JButton();
  private JButton stopButton = new JButton();
  private JButton exitButton = new JButton();
  private JLabel startLabel = new JLabel();
  private JLabel stopLabel = new JLabel();
  private JLabel elapsedLabel = new JLabel();;
  private JTextField startTextField = new JTextField();
  private JTextField stopTextField = new JTextField();
  private JTextField elapsedTextField = new JTextField();

  //variables
  private long startTime;
  private long stopTime;
  private double elapsedTime;
  private void startButton_event(ActionEvent e)
  {
    startTime = System.currentTimeMillis(); //seconds 
    startTextField.setText(String.valueOf(startTime));
    stopTextField.setText(" ");
    elapsedTextField.setText(" ");
    setTitle("Started time");

  }

   private void stopButton_event(ActionEvent e)
  {
    stopTime = System.currentTimeMillis();//seconds 
    stopTextField.setText(String.valueOf(stopTime));
    elapsedTime = (stopTime - startTime)/1000;
    elapsedTextField.setText(String.valueOf(elapsedTime));
    setTitle("stopped time ");

  }
  public Watch()
  {
    setTitle("Stop Watch");
    setSize(500,300);
    setLayout(null);
    setLayout(new GridBagLayout());
    GridBagConstraints gridConstraints = new GridBagConstraints();

    // start button 
    startButton.setText("Start timing ");
    gridConstraints.gridx = 0; 
    gridConstraints.gridy =0 ;
    add(startButton,gridConstraints);

    startButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        startButton_event(e);
      }
    });

   
    //stop button 
    stopButton.setText("stop timing ");
    gridConstraints.gridx =0;
    gridConstraints.gridy =1; 
    add(stopButton,gridConstraints);
    //setVisible(true);

    stopButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        stopButton_event(e);
      }
    });


    //exit button 
    exitButton.setText("Exit");
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 2;
    add(exitButton, gridConstraints);
    exitButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    });

    startLabel.setText("Start Time");
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 0;
    add(startLabel, gridConstraints);

    stopLabel.setText("Stop Time");
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 1;
    add(stopLabel, gridConstraints);


    elapsedLabel.setText("Elapsed Time (sec)");gridConstraints.gridx = 1;
    gridConstraints.gridy = 2;
    add(elapsedLabel, gridConstraints);

    startTextField.setText("");
    startTextField.setColumns(15);
    gridConstraints.gridx = 2;
    gridConstraints.gridy = 0;
    add(startTextField, gridConstraints);

    stopTextField.setText("");
    stopTextField.setColumns(15);
    gridConstraints.gridx = 2;
    gridConstraints.gridy = 1;
    add(stopTextField, gridConstraints);

    elapsedTextField.setText("");
    elapsedTextField.setColumns(15);
    gridConstraints.gridx = 2;
    gridConstraints.gridy = 2;
    add(elapsedTextField, gridConstraints);
    setVisible(true);
   



  }

}

public class StopWatch 
{
  public static void main(String[] args)
  {
    Watch w = new Watch();
  }
}