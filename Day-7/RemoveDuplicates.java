
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        num.add(10);
        num.add(30);
        num.add(20);
        num.add(20);
        num.add(10);
        num.add(30);
        num.add(20);
        num.add(40);
        List<Integer> unique = new ArrayList<>();
        for(int i : num){
            if(!unique.contains(i)){
                unique.add(i);
            }
        }
        Collections.sort(unique);
        System.out.println("After Removing Duplicates: " + unique);
    }
}
