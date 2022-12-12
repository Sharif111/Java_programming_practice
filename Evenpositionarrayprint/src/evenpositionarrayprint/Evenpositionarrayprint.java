package evenpositionarrayprint;

import java.util.Scanner;


public class Evenpositionarrayprint {

    
    public static void main(String[] args) {
        int n;
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter array size: ");
         n=sc.nextInt();
         int[] arr=new int[n];
         
         System.out.println("Enter array Elements: ");
         for(int i=0;i<arr.length;i++){
           arr[i]=sc.nextInt();
       }
         
         for(int i=0;i<arr.length;i++){
             if((arr[i])%2==0){
          System.out.print(arr[i] + "  ");
             }
       }        
    }
    
}
