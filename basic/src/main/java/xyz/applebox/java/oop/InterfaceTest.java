package xyz.applebox.java.oop;

public class InterfaceTest {
    public static void main(String[] args) {
        Car car = new Car("블랙이");
        car.introduce();
    }
}

interface Vehicle {
    String getName();

    static String code() {
        return "200";
    }

    default void introduce() {
        System.out.printf("이름: %s, 코드: %s%n", getName(), code());
    }
}

class Car implements Vehicle {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}