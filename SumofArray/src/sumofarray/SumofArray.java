package sumofarray;

import java.util.Scanner;


public class SumofArray {

    
    public static void main(String[] args) {      
         int n;
         int sum=0;
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter array size: ");
         n=sc.nextInt();
         int[] arr=new int[n];
         
         System.out.println("Enter array Elements: ");
         for(int i=0;i<arr.length;i++){
           arr[i]=sc.nextInt();
    }
         
         for(int i=0;i<arr.length;i++){
           sum=sum+arr[i];
    }
          System.out.println("Sum of the array:" +sum); 
        
      
    
      }
}
