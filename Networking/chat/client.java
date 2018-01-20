package sk ;

import java.io.* ;
import java.net.* ;
import java.util.Scanner ;
//import features.censor ;
/*
class recv implements Runnable {
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
*/

class client {

    public static void main(String a[]) {
        Scanner s = new Scanner(System.in) ;

        try{      

            Socket socket =new Socket("localhost",Integer.parseInt(a[0]));  
            DataOutputStream dout = null ;
            DataInputStream din = null ;
            String []words ;
            new recv(socket) ;

           while(true){

                dout = new DataOutputStream(socket.getOutputStream());  
                System.out.print("You \t") ;
                String chat = s.nextLine() ;
                /*
                words = chat.split(" ") ;
                chat = "" ;
                for(String w : words) {
                    chat += censor.check(w) ;
                    chat += " " ;

                }*/
                dout.writeUTF(chat);  
                
                if(chat == "endit\n")  {
                    break ;
                }


           }

            dout.flush();  
            dout.close();  
            socket.close();  

        }catch(Exception e){System.out.println(e);}  


    }          

}
