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
        JFrame f = new JFrame("File");
        f.setLayout(null) ;
        f.setSize(400 , 400) ;
        f.setVisible(true) ;

        JLabel l = new JLabel("Progress Here");
        l.setBounds(20,20,200,30);

        JTextField tf = new JTextField() ;
        tf.setBounds(50 ,50 , 200 ,30) ;

        JButton b1 = new JButton("ENCRYPT");
        JButton b2 = new JButton("DECRYPT");

        b1.setBounds(50,100,90,30);
        b2.setBounds(150,100,120,30);

        f.add(tf);
        f.add(l);
        f.add(b1);
        f.add(b2);


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