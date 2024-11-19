package hust.soict.dsai.lab01;
import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of rows: ");
    int rows = sc.nextInt();
    for (int i = 0; i <= (rows-1); i++){
        for (int j = 0; j < (rows-i-1); j++){
            System.out.print(" ");
        }
        for (int k = 0; k < (2*i+1); k++){
            System.out.print("*");
        }
        System.out.println();
    }
    }

}
