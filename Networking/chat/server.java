import java.io.*;  
import java.net.*;  
import java.util.Scanner ;


public class server {  

public static void main(String[] a){      
    Scanner s = new Scanner(System.in) ;
    try{  
        int port ;
        if(a.length == 1 ) {
            port = Integer.parseInt(a[0]) ;
        } else {
            port = 3000; //Default Port
        }

        ServerSocket  serverSocket = new ServerSocket(port);  
        Socket socket = serverSocket.accept();//establishes connection   
        DataOutputStream dout = null ;
        String chat = "" ;
        String []words ;

        new recv(socket) ;

        while(true) {
            
            dout = new DataOutputStream(socket.getOutputStream()) ;
            System.out.print("You: \t") ;
            chat = s.nextLine() ;
            
            if(chat.compareTo("endit") == 0) {
                break ;
            }
            
            dout.writeUTF( chat ) ;

        }

        dout.flush() ;
        dout.close() ;
        
        serverSocket.close();  
            
    }catch(Exception e){System.out.println(e);}  
    
    }  

}  