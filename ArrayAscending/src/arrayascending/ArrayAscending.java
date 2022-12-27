package arrayascending;

import java.util.Scanner;


public class ArrayAscending {

    
    public static void main(String[] args) {
            int n;
            int temp=0;
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter Array Size:");
            n=sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter Array elements: ");
            for(int i=0; i<n; i++)
            {
                arr[i]=sc.nextInt();
            }
                       
            for (int i=0; i<arr.length; i++)
            {
                for(int j=i+1;j<arr.length;j++)
                {
                   if(arr[i] > arr[j]) 
                   {    
                   temp = arr[i];    
                   arr[i] = arr[j];    
                   arr[j] = temp;    
                   }                
             }
            }
             System.out.println();    
        System.out.println("Elements of array sorted in ascending order: ");    
        for (int i = 0; i < arr.length; i++) {     
            System.out.print(arr[i] + " ");
        }
    }
}
