package patternsample1;

import java.util.Scanner;

public class PatternSample1 {

    
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        System.out.println("Enter a row number");
        int n=sc.nextInt();
        for(int row=n;row>=1;row--){
            for(int col=1;col<=row;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
}
