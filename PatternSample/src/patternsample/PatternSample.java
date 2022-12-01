package patternsample;

import java.util.Scanner;


public class PatternSample {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a row number");
        int row=sc.nextInt();
        System.out.println();
        for(int i=1;i<=row;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
}
