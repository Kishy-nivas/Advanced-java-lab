import java.io.FileInputStream ;
import java.io.IOException ;
import java.io.ObjectInputStream ;

class objectDeser {
    public static void main(String a[]) {
        String fileName = "myObject.ser" ;

    try {
        FileInputStream inputHandle = new FileInputStream(fileName) ;
        ObjectInputStream in = new ObjectInputStream(inputHandle) ;

        int x ;
        Demo Obj = null ;
        
        Obj = (Demo)in.readObject() ;
        System.out.println("DeSerialized !") ;

        System.out.print(" A --> " + Obj.a + " B --> "+ Obj.b ) ;

        in.close() ;
        inputHandle.close() ;

    } catch ( IOException e ) {
        System.out.print("An Exception") ;
    } catch ( ClassNotFoundException e ) {
        System.out.print("Class Exception") ;
    }

    }
}