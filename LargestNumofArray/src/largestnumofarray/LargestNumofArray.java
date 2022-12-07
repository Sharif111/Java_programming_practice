package largestnumofarray;


public class LargestNumofArray {

    
    public static void main(String[] args) {
        int arr[]=new int[]{20,2,25,100,500};
        int max=arr[0];
       for(int i = 0;i<arr.length;i++){
           if(arr[i]>max)
               max=arr[i];               
      }
        System.out.println("Largest value from given array :" +max);
       
   }
    
}
