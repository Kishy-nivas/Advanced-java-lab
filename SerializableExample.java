import java.io.*;

/**
 *
 * @author Kishy Nivas 
 */

class Student implements Serializable 
{
    public String name; 
    public int rollno;
    public int age;
    Student(String name ,int rollno, int age)
    {
        this.name = name;
        this.rollno= rollno;
        this.age= age;
    }
    
    
    
}
public class SerializableExample  {
    public static void printData(Student s )
    {
        if (s== null){
            System.out.println("Null data ");
            return;
        }
        System.out.println("Name : " + s.name);
        System.out.println("Roll no  : " + s.rollno);
        System.out.println("age: " + s.age);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        
        Student obj = new Student("kishore",23,21);
        String fileName = "outfile.txt";
        try
        {
            FileOutputStream  file= new FileOutputStream(fileName);
            ObjectOutputStream ob_file = new ObjectOutputStream(file);
            ob_file.writeObject(obj);
            
            
            
            
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found : " + fileName);
            
        }
        System.out.println("Before serialization : " );
        printData(obj);
        obj = null; 
        printData(obj);
        try
        {
            FileInputStream  file= new FileInputStream(fileName);
            ObjectInputStream ob_file = new ObjectInputStream(file);
            obj= (Student) ob_file.readObject();
            
            
            
            
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("file not found " + fileName );
            
        }
        System.out.println("After deserialization ");
        printData(obj);
   
        
    }
    
}