//You are given a string s. In one move you can change any character to another character.
//You have to make a string which consists of the same character. Find the minimum move to do this task.

import java.util.Scanner;

public class MinimumMovesToSameCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }


        int maxFreq = 0;
        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
            }
        }

        int minMoves = s.length() - maxFreq;
        System.out.println(minMoves);
    }
}
