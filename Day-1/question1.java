//Write a program that takes two numbers as input from the user and performs arithmetic operations on them using the arithmetic operators (sum, difference, product, quotient, remainder) in Java.

import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: Write your code here
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int S = num1 + num2;
        int D = num1 - num2;
        int P = num1 * num2;
        int Q = 0, R = 0;
        if(num2 != 0){
            Q = num1 / num2;
            R = num1 % num2;
        } else {
            System.out.println("Cannot divide by zero.");
        }
        
        System.out.println("Sum: " + S);
        System.out.println("Difference: " + D);
        System.out.println("Product: " + P);
        System.out.println("Quotient: " + Q);
        System.out.println("Remainder: " + R);

        scanner.close();
    }
}
