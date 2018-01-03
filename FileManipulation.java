import java.io.*;
import java.util.*;



class FileOperations{
  private String FileName; 
  private File file;
  private Scanner sc;

  public FileOperations(String name) throws IOException{
    this.FileName = name; 
    this.file = new File(this.FileName);
    if (!this.file.exists()){
      file.createNewFile();

    }
    this.sc= new Scanner(System.in);
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
    if(dir_level <=0){
      System.out.println("Invalid value ");
      return;
    }
    char c= '.';
    char[] repeat = new char[dir_level];
    Arrays.fill(repeat, c);
    String dir = new String(repeat);
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
  public void deleteFile(String filename ){
    File delete_file = new File(filename);
    if(delete_file.equals(this.file)){
      System.out.println("Can't delete the current working file");
      return;
    }

    if(delete_file.exists()){
      delete_file.delete();
      System.out.println("File deleted successfully ");

    }
    else{
      System.out.println("File doesnt exist");
    }

  }

  public String getFileExtension(String file_name){
      String[] splits = file_name.split("\\.");
      String extension = "";
      if(splits.length >= 2){
            extension = splits[splits.length-1];
      }
      return extension;

  }

  public void listAllFilesByExtension(String extension){
    File currDir = new File(".");
    File[] filesList  = currDir.listFiles();
    for (File f: filesList){
      if (getFileExtension(f.getName()).equals(extension)){
        System.out.println(f.getName());
      }
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
  public void getRoot(){
    System.out.println(System.getProperty("user.home"));
  }

  public void createTemp() throws IOException{
    File temp = File.createTempFile("abc",null);
  }

  public void getPath (){
    System.out.println(file.getAbsolutePath());
  }
}
class FileManipulation{
  public static void main(String[] args)throws IOException{
    Scanner main_scanner = new Scanner(System.in);
    System.out.println("Enter the file name to start the operations ");
    String currFile = main_scanner.nextLine();
    FileOperations f = new FileOperations(currFile);
    int choice ;                                                //menu is so big, because can't find a way to do multiple-string 
    String menu = "1. list \n2.Append file \n3.Rename file \n4.Delete file \n5.getRoot \n6. Quit \n7. Get file name \n8.find file \n9.Find and replace \n10 Get file extension \n11 list by extension \n 12 Get absoulute path \n13.create temp";
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
          main_scanner.nextLine();
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
        case 10:
          main_scanner.nextLine();
          System.out.println("Enter the filename to find it's extension : ");
          String file_extension = main_scanner.nextLine();
          System.out.println(f.getFileExtension(file_extension));
          break;
        case 11: 
          main_scanner.nextLine();
          System.out.println("Enter the extension name to list files:");
          String file_extension1 = main_scanner.nextLine();
          f.listAllFilesByExtension(file_extension1);
        case 12:
          f.getPath();
          break;
        case 13:
          f.createTemp();
          break;
        }

    }while(choice!=6);
  }
}