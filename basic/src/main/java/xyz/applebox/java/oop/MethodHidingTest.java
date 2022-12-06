package xyz.applebox.java.oop;

public class MethodHidingTest {
    public static void main(String[] args) {
        Fruit.introduce();
        Apple.introduce();
    }
}

class Fruit {
    public static void introduce() {
        System.out.println("나는 과일 입니다");
    }
}

class Apple extends Fruit {
    public static void introduce() {
        System.out.println("나는 사과 입니다");
    }
}

enum Sex {
    M, W
}