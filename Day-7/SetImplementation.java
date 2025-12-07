import java.util.*;
public class SetImplementation {
    public static void main(String[] args) {
        Set<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Orange");
        colors.add("Red");
        colors.add("Blue");
        colors.add(null);
        colors.add(null);
        System.out.println(colors);
        System.out.println(colors.size());
        System.out.println(colors.contains("Green"));
        colors.remove("Blue");
        System.out.println(colors);
        System.err.println();

        Set<Integer> num = new TreeSet<>();
        num.add(30);
        num.add(25);
        num.add(56);
        num.add(10);
        System.out.println(num);
    }
}
