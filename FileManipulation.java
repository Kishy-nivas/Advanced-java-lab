import java.io.*;
import java.util.*;



class FileOperations{
  private String FileName; 
  private File file;
  private Scanner sc;

  public FileOperations(String name){
    this.FileName = name; 
    this.file = new File(this.FileName);
    if (!this.file.exists()){

    }
    this.sc= new Scanner(System.in);
  }

  public void setFile(String name ){
    this.FileName = name;
  }

  public String getFile(String name){
    return this.FileName;
  }

  public void writeFile(){

  }

  public void getFilename(){
    System.out.println(this.file.getName());
  }

  public void appendFile(){
    FileWriter out;
    try{
       out = new FileWriter(this.FileName,true);        // append mode set 
       System.out.println("Enter the line  to append ");
       String input_text = sc.nextLine();
       out.write(input_text);
       out.close();
       System.out.println("Text appended successfully");
     }
     catch(Exception e){
      System.out.println("Exception occured !");
     }

  }

  public void findFile(String file_name){
    File currDir =  new File(".");
    File[] fileList = currDir.listFiles();
    for(File f: fileList){
      if(f.getName().equals(file_name)){
        System.out.println("successfully found in the current directory  " + file_name);
        return;
        }
      }
      System.out.println("Cannot find the specified file ");
    }
    

 

  public void listAllFiles(int dir_level){
    String dir = "." * dir_level;
    File currDir = new File(dir);
    getAllFiles(currDir);

  }


  private void getAllFiles(File currDir ){
    File[] filesList  = currDir.listFiles();
    for (File f: filesList){
      if (f.isDirectory()){
        System.out.println(f.getName());
      }
      if (f.isFile()){
        System.out.println(f.getName());
      }
    }
  }

  public  void replaceFile(){

  }

  public void deleteFile(String filename ){
    File delete_file = new File(filename);
    if(delete_file.exists()){
      delete_file.delete();
      System.out.println("File deleted successfully ");

    }
    else{
      System.out.println("File doesnt exist");
    }

  }

  public void renameFile(String newName){
    if(file.exists()){
      file.renameTo(new File(newName));
      this.file = new File(newName);
      this.FileName = newName;

    }
    else{
      System.out.println("File doesn't exist!");
    }
  }

  public void FindAndReplace(String findText , String replaceText) {
     try{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "", oldtext = "";
        while((line = reader.readLine()) != null)
        {
          oldtext += line ;
        }
        reader.close();

        String replacedtext  = oldtext.replace(findText,replaceText);


        FileWriter writer = new FileWriter(file);
        writer.write(replacedtext);
        writer.close();
        System.out.println("successfully replaced!!!");

      }
        catch (IOException ioe){
            ioe.printStackTrace();
         }
  }

  public void fileStatistics(){

  }
  public void getRoot(){
    System.out.println(System.getProperty("user.home"));
  }
}













class FileManipulation{
  public static void main(String[] args)throws IOException{
    Scanner main_scanner = new Scanner(System.in);
    System.out.println("Enter the file name to start the operations ");
    String currFile = main_scanner.nextLine();
    FileOperations f = new FileOperations(currFile);
    int choice ;
    String menu = "1. list \n2.Append file \n3.Rename file \n4.Delete file \n5.getRoot \n6. Quit \n7. Get file name \n8.find file \n9.Find and replace ";
    String new_file_name;
    
    do{
      System.out.println(menu);
      System.out.println("Enter the choice ");
      choice = main_scanner.nextInt();
      switch(choice){
        case 1:
          System.out.println("Enter the dir level, (1 for current) :");
          int dir_level = main_scanner.nextInt();


          f.listAllFiles(dir_level);
        break;
        case 2: 
          f.appendFile();
        break;
        case 3:
          System.out.println("Enter the new name for the file ");
          main_scanner.nextLine();
          new_file_name = main_scanner.nextLine();
          f.renameFile(new_file_name);
        break;
        case 4:
          System.out.println("Enter the file  name to delete ");
          String delete_file = main_scanner.nextLine();
          f.deleteFile(delete_file);
        break;
        case 5:
          f.getRoot();
        break;
        case 6:
          break;
        case 7:
          f.getFilename();
          break;
        case 8:
          System.out.println("Enter the file name to be found in the current directory : ");
          main_scanner.nextLine();
          String find_file = main_scanner.nextLine();
          f.findFile(find_file);
          break;
        case 9:
          main_scanner.nextLine();
          System.out.println("Enter the text to be found: ");
          String find = main_scanner.nextLine();
          System.out.println("Enter the text to be replaced with : ");
          String replace= main_scanner.nextLine();
          f.FindAndReplace(find.trim(),replace.trim());
          break;
      }

    }while(choice!=6);
  }
}