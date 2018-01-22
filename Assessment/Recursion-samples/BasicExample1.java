class BasicExample1
{
  public static void test(int n)
  {
    if (n>0)
    {
      System.out.println(n); // prints the number in reverse order 
      test(n-1);
      System.out.println(n); // prints the number in original order 
    }
  }


  public static void main(String[] args) 
  {
    test(4);

    
  }
}