class DecimalToBinary 
{
  public static void dec_to_bin(int n)
  {
    if(n>0)
    {
      dec_to_bin(n/2);
      System.out.print(n%2); // top to bottom 
    }

  }
  public static void main(String[] args) 
  {
    dec_to_bin(12); //0011 
    System.out.println(" ");
    dec_to_bin(5);
    
  }
}