package copyarray;

import java.util.Scanner;

public class CopyArray {    
    public static void main(String[] args) {
            int n;
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter Array Size:");
            n=sc.nextInt();
            int[] arr1 = new int[n];
            System.out.println("Enter Array elements: ");
            for(int i=0; i<n; i++)
            {
                arr1[i]=sc.nextInt();
            }
            
            System.out.println("Your Given array: ");
            for (int i=0; i<n; i++)
            {
                System.out.println(arr1[i]);
            }            
             
        int arr2[] = new int[arr1.length];    
            
        for (int i = 0; i < arr1.length; i++) {     
            arr2[i] = arr1[i];     
        }   
        
         //Displaying elements of array arr1     
        System.out.println("Elements of original array: ");    
        for (int i = 0; i < arr1.length; i++) {     
           System.out.print(arr1[i] + " ");    
        }     
            
        System.out.println();    
            
        //Displaying elements of array arr2     
        System.out.println("Elements of new array: ");    
        for (int i = 0; i < arr2.length; i++) {     
           System.out.print(arr2[i] + " ");    
        }     
    }    
}    