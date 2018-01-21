import javax.swing.*;  
//import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random ;
import java.util.Scanner ;

class giu {
    public static void main(String []a) {

        //Non GUI
        int fixedRandomNumber , userGuess ;     
        Random  r =  new Random() ;
        //Fixed Random Number
        fixedRandomNumber = r.nextInt(101) ;
        userGuess = -1 ;


        //Frame
        JFrame f = new JFrame("The Game HHH") ;
        f.setLayout(null) ;
        f.setSize(400 , 400) ;
        f.setVisible(true) ;

        //TextBox

        JTextField tf = new JTextField() ;
        tf.setBounds(50 ,50 , 200 ,30) ;

        //Button

        JButton jb = new JButton("Guess") ;
        JButton reset = new JButton("Reset") ;

        jb.setBounds(50 , 100 , 90 , 30) ;
        reset.setBounds(150 , 100 , 150 , 30) ;

        //Label

        JLabel jl = new JLabel("Message here") ;
        jl.setBounds(50 , 130 , 150 , 30 ) ;

        //Listen to events

        jb.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event){ 
                String textBoxText = tf.getText() ;

                Integer x = Integer.parseInt(textBoxText) ;

                if(x < fixedRandomNumber) {
                    jl.setText("Guess Was less") ; 
                } else if(x > fixedRandomNumber){
                    jl.setText("Guess Was more") ;
                } else {
                    jl.setText("You won") ;
                    tf.setEditable(false) ;
                }
                            
                System.out.println(textBoxText) ;
            }

        });

        reset.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tf.setEditable(true) ;
                    tf.setText("0") ;
                    //fixedRandomNumber = r.nextInt(101) ;

                }
            }
        ) ;

        //Add Components

        f.add(tf) ;
        f.add(jb) ;
        f.add(jl) ;
        f.add(reset) ;
    }
}