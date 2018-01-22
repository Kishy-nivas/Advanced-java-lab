import java.io.Serializable ;
import java.io.ObjectOutputStream ;
import java.io.FileOutputStream ;
import java.io.IOException ;

class Demo implements Serializable {
    public int a ;
    public int b ;

    Demo(int a , int b) {
        this.a = a ;
        this.b = b ;
    }

}

class objectSer{
    public static void main(String []a) {

        Demo ob = new Demo (45 , 50) ;
        String fileName = "myObject.ser" ;

    try {
        FileOutputStream outputHandle = new FileOutputStream(fileName) ;
        ObjectOutputStream out = new ObjectOutputStream(outputHandle) ;

        out.writeObject(ob) ;

        out.close() ;
        outputHandle.close() ;

        System.out.println("Serilization Done") ;

    } catch(IOException e ) {

    }
 
        

    }
}