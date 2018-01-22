class FindMin
{
  public static void find_min(int[] arr, int index,int curr_min )
  { 
    if (index < 0 )                                          // array is over 
    {
      System.out.println("Lowest value is " + curr_min ) ;
      return;
    }
    if  (arr[index] < curr_min) 
      curr_min = arr[index];
    find_min(arr,index-1,curr_min);            //recursively call the method ...


  }
  public static void main(String[] args) 
  {
    int[] arr  = {
      5,4,2,1,4,5,-99
    }; 
    int curr_min = 9999;       // use some big values..... 
    find_min(arr,arr.length-1,curr_min); 
    
  }
}