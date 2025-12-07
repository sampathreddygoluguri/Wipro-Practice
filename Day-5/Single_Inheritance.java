class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
    }
}

class Student extends Person {
    int roll;

    public Student(String name, int roll) {
        super(name);
        this.roll = roll;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Roll no: " + roll);
    }
}

public class Single_Inheritance {
    public static void main(String[] args) {
        Student st1 = new Student("sampath", 27);
        st1.displayInfo();
    }
}