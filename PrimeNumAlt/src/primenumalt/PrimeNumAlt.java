package primenumalt;

import java.util.Scanner;


public class PrimeNumAlt {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int num=sc.nextInt();
        int i,flag=0;
        int temp=num/2;
        if(num==0||num==1)
        {
            System.out.println(num+" is not a prime num");
        }
        else
        {
          for(i=2;i<=temp;i++)
         {      
           if(num%i==0)
           {      
               System.out.println(num+" is not a prime number");      
               flag=1;      
               break;      
           }      
         }
          if(flag==0)  
         { 
             System.out.println(num+" is a prime number");  
         }
        }
        
      
        
    }
    
}

