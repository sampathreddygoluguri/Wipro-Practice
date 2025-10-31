//Sort the Collection
//students are provided with a challenge to sort the given arraylist in the lesser lines of code. Student with minimum lines will win , try to write a code for it in less lines and win

import java.util.*;
public class Main {

    public static void main(String[] args) {
        //write your answer here
        Scanner sc = new Scanner(System.in);
        List<Integer> num = new ArrayList<>();
        while(sc.hasNextInt()){
            num.add(sc.nextInt());
        }
        
        System.out.println("List before sort: " + num);
        Collections.sort(num);
        System.out.println("List after sort: " + num);
    }
}
