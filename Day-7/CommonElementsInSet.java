import java.util.*;
public class CommonElementsInSet {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        Set<Integer> set2 = new HashSet<>();
        // set2.add(3);
        // set2.add(4);
        set2.add(5);
        set2.add(6);
        set1.retainAll(set2);
        //printing common elements
        System.out.println("Common Elements are: " + set1);
        System.out.println();

        //for finding no common elements
        boolean res = set1.isEmpty();
        System.err.println(res);
    }
}
