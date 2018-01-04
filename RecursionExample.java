import java.io.* ; 

public class RecursionExample{
  private static void Find(int[] arr,int key, int start,int end ){
    int mid; 
    mid = (start+end)/2;
    if(start>end){ System.out.println("Value not found "); return;}
    if (arr[mid] == key){
      System.out.println("value found at index "+mid);
      return;
    }
    else if (arr[mid]>key){
      Find(arr,key,start,mid-1);
    }
    else{
      Find(arr,key,mid+1,end);

    }

  }
  public static void main(String[] args){
    int[] arr  = {
      2,3,3,4,5,6,7,8
    };
    int key =9;
    Find(arr,key, 0,arr.length-1);
  }
}