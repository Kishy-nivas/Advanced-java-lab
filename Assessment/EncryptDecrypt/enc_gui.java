import javax.swing.*;  
//import java.awt.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random ;
import java.util.Scanner ;
class enc_gui {

    public static void main(String a[]){

        int key = 1 ;
        JFrame  f = new JFrame ("FIle Encrupt-decrypt software");
        f.setLayout(new GridLayout(15,4));
        f.setSize(500 , 400) ;

       

        JLabel l = new JLabel("Enter the file name above ");
        l.setBounds(20,20,200,30);

        JTextField tf = new JTextField() ;
        tf.setBounds(50 ,50 , 200 ,30) ;

        JButton b1 = new JButton("ENCRYPT");
        JButton b2 = new JButton("DECRYPT");

        b1.setBounds(50,100,90,30);
        b2.setBounds(150,100,120,30);

        f.add(tf);      // add everthing to the frame 
        f.add(l);
        f.add(b1);
        f.add(b2); 
        f.setVisible(true) ; // always must be at last, so labels, and commands are drawn over the frame  


        //Action Listner ;

        b1.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String fn = tf.getText() ;
                    enc.encrypt(fn ,key) ;
                    l.setText("Encrypted") ;
                }
            }
        ) ;

        b2.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String fn = tf.getText() ;
                    enc.decrypt(fn ,key) ;
                    l.setText("Decrypted") ;
                }
            }
        ) ;
        
    }
}