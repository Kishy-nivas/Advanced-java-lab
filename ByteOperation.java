import java.io.*;
import java.util.*;

class ByteHandling
{
  private String fileName;

  public void getfileName(String name )
  {
    this.fileName = name;

  }

  public void TransferData(String in_file ,String out_file ) throws IOException
  {
    try
    {
      InputStream input_stream = new FileInputStream(in_file);
      OutputStream output_stream = new FileOutputStream(out_file);
     

      byte[] buffer =  new byte[8];
      int bytes;
      System.out.println("Transferring data .....");
      while((bytes = input_stream.read(buffer))> 0 )
      {
         output_stream.write(buffer,0,bytes);

      }
      System.out.println("File transfer finished");
    }

    catch(FileNotFoundException e)
    {
      System.out.println("File not found " +this.fileName);
    }
  }
}




public class ByteOperation
{
  public static void main(String[] args) throws IOException
  {
    ByteHandling b = new ByteHandling();
    b.TransferData("sample.txt","outfile.txt");
  }
}

