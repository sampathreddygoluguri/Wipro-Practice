import java.util.*;
public class MergingLists {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(5);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(7);
        list2.add(8);
        list2.add(3);
        List<Integer> merged = new ArrayList<>();
        List<Integer> unique = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);
        System.out.println("Merged List:" + merged);
        for(int k : merged){
            if(!unique.contains(k)){
                unique.add(k);
            }
        }
        Collections.sort(unique);
        System.out.println("Sorted List:" + unique);

    }
}
