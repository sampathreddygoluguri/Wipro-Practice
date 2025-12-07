import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondLargest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(25);
        numbers.add(16);
        numbers.add(49);
        numbers.add(73);
        Collections.sort(numbers);
        System.out.println("Second Largest Number is: " + numbers.get(numbers.size()-2));
    }
}
