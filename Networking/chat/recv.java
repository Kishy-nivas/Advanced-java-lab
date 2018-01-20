package sk ;
import java.io.*;  
import java.net.*;    

public class recv implements Runnable {
    DataInputStream din = null ;
    Thread t ;
    Socket socket ;
    recv(Socket socket) {
        t = new Thread(this , "Reac Process") ;
        this.socket = socket ;
        t.start() ;
    }

    public void run() {
        while(true) {
            try{
                din = new DataInputStream(socket.getInputStream()) ;
                String str = (String)din.readUTF() ;
                System.out.println("\rOther Guy : "+str) ;
                System.out.print("You: \t") ;

            } catch (IOException e) {

            }

        }
    }

}