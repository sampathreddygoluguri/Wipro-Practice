import java.util.ArrayList;
import java.util.List;

public class ListImplementation {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(25);
        numbers.add(16);
        numbers.add(49);
        System.out.println(numbers);
        numbers.remove(0);
        System.out.println(numbers);
        numbers.set(0, 50);
        System.out.println(numbers);
        System.out.println(numbers.size());

    }
}
