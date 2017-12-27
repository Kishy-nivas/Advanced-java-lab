import java.io.*;
import java.util.*;
class FileHandling
{
	private String fileName;

  public void getFileName(String fileName)
  {
    this.fileName = fileName;
  }
  public void writeFile() throws IOException
  {
    try
    {
      FileWriter file = new FileWriter(this.fileName);
      BufferedWriter buffered_writer  = new BufferedWriter(file);
      Scanner sc= new Scanner(System.in);
      System.out.println("Enter a text to write ");
      String input_text = sc.nextLine();
      buffered_writer.write(input_text);
      buffered_writer.close();



    }
    catch(FileNotFoundException e) 
    {
      System.out.println("File not found " + fileName);
    }

  }
  public void readFile() throws IOException
  {
    try
    {
      FileReader file = new FileReader(this.fileName);
      BufferedReader buffered_reader= new BufferedReader(file);
      Scanner sc = new Scanner(System.in);
      System.out.println("Reading the file ...");
      String line = null;
      while((line = buffered_reader.readLine())!=null)
      {
        System.out.println(line);
      }

    }
    catch(FileNotFoundException e)
    {
      System.out.println("File not found " + this.fileName);
    }
  }




}
class FileOperation

{
    public static void main(String[] args) throws IOException 
  {
    FileHandling s= new FileHandling();
    s.getFileName("sample.txt");
    s.writeFile();
    s.readFile();
    


  

    
  }

}


