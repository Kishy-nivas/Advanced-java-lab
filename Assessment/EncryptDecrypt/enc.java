import java.io.File ;
import java.io.FileNotFoundException ;
import java.io.FileOutputStream ;
import java.io.FileInputStream ;
import java.io.IOException ;

class enc {

    public static void encrypt(String fileName , int key) {
        FileInputStream inputHandle = null ;
        FileOutputStream outputHandle = null ;

        try {
            inputHandle = new FileInputStream(fileName) ;
            outputHandle = new FileOutputStream("enc_"+fileName) ;

            int c ;
            while( ( c = inputHandle.read() ) != -1) {
                c += key ;
                outputHandle.write( (byte) c ) ;
                //System.out.print((char)c) ;

            }
            inputHandle.close() ;
            outputHandle.close() ;


        } catch(FileNotFoundException e) {

        } catch (IOException e) {

        }

    }

    public static void decrypt(String fileName , int key) {
        FileInputStream inputHandle = null ;
        FileOutputStream outputHandle = null ;

        try {
            inputHandle = new FileInputStream(fileName) ;
            outputHandle = new FileOutputStream("dec_"+fileName) ;

            int c ;
            while( ( c = inputHandle.read() ) != -1) {
                c -= key ;
                outputHandle.write( (byte) c ) ;
                //System.out.print((char)c) ;

            }
            inputHandle.close() ;
            outputHandle.close() ;


        } catch(FileNotFoundException e) {

        } catch (IOException e) {

        }

    }

}