package patternsample;

import java.util.Scanner;


public class PatternSample {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a row number");
        int n=sc.nextInt();
        System.out.println();
        for(int row=1;row<=n;row++){
            for(int col=1;col<=row;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
}
