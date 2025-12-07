public class TypeCastingDemo {
    public static void main(String[] args) {
        System.out.println("------------------");
        System.out.println("Object casting");
        System.out.println("------------------");
        car c1 = new car();
        // upcasting
        vehicle v = c1;
        v.run();
        // downcasting
        car c2 = (car) v;
        c2.brake();

        // Implicit
        int i = 10;
        double l = i;
        System.out.println("Integer: " + i);
        System.out.println("Double: " + l);

        // Explicit
        double a = 98.24;
        int b = (int) a;
        char c = (char) a;
        System.out.println("Original value: " + a);
        System.out.println("After type casting to int: " + b);
        System.out.println("After type casting to char: " + c);

    }
}

class vehicle {
    void run() {
        System.out.println("Engine is running!");
    }
}

class car extends vehicle {
    void run() {
        System.out.println("Car Engine is running!");
    }

    void brake() {
        System.out.println("Applying Brakes!");
    }
}
