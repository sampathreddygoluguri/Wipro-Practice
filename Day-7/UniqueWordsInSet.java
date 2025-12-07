import java.util.*;
public class UniqueWordsInSet {
    public static void main(String[] args) {
        String input = "Java is fun and Java is powerful";
        String[] words = input.split(" ");
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }
        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Number of unique words: " + uniqueWords.size());
    }
}

