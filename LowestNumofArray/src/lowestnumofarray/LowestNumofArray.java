package lowestnumofarray;


public class LowestNumofArray {

    
    public static void main(String[] args) {
       int arr[]=new int[]{20,2,25,100,500};
        int min=arr[0];
       for(int i = 0;i<arr.length;i++){
           if(arr[i]<min)
               min=arr[i];               
      }
        System.out.println("Largest value from given array :" +min);
    }
    
}
