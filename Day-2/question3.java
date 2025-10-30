//Write a function to reverse each word in a string.

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        //write your answer here
        Scanner sc=new Scanner(System.in);
        String input="Great Learning";

        System.out.println(reverseWords(input));
        sc.close();

    }
    public static String reverseWords(String str){
        String[]  words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for(String word : words) {
            StringBuilder reversed = new StringBuilder(word);
            result.append(reversed.reverse().toString()).append(" ");
        }
        return result.toString().trim();
    }
}
