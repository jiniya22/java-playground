package xyz.applebox.java.oop;

public class CovarientMethodOverrideTest {
    public static void main(String[] args) {
        System.out.println(new Square(3).area());
        System.out.println(new Circle(3).area());

    }
}

interface Shape {
    Number area();
}

class Square implements Shape {
    private int width;

    public Square(int width) {
        this.width = width;
    }

    @Override
    public Integer area() {
        return width * width;
    }
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public Double area() {
        return Math.PI * Math.pow(radius, 2.0);
    }
}