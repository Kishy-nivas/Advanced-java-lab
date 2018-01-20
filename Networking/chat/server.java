package sk ;
import java.io.*;  
import java.net.*;  
import java.util.Scanner ;
import sk.recv ;


public class server {  

public static void main(String[] args){      
    Scanner s = new Scanner(System.in) ;
    try{  

        ServerSocket  serverSocket = new ServerSocket(Integer.parseInt(args[0]));  
        Socket socket = serverSocket.accept();//establishes connection   
        DataOutputStream dout = null ;
        String chat = "" ;
        String []words ;

        new sk.recv(socket) ;

        while(chat != "endit") {
            
            dout = new DataOutputStream(socket.getOutputStream()) ;
            System.out.print("You: \t") ;
            chat = s.nextLine() ;
            /*
            words = chat.split(" ") ;
            chat = "" ;
            for(String w : words) {
                chat += censor.check(w) ;
                chat += " " ;

            }
            */

            dout.writeUTF( chat ) ;


        }

        dout.flush() ;
        dout.close() ;
        
        serverSocket.close();  
            
    }catch(Exception e){System.out.println(e);}  
    
    }  

}  