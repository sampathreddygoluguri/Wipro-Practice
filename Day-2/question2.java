//Write a program that takes the row & columns input from the user to populate a 2D array and then prints the array.

import java.util.Scanner;

public class MultidimensionalArrayExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: Write your code here
        int row = scanner.nextInt();
        int coloumn = scanner.nextInt();
        int[][] arr=new int[row][coloumn];
        for(int i=0; i< row; i++){
            for(int j = 0; j < coloumn; j++) {
                arr[i][j] = scanner.nextInt();
             }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < coloumn; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
