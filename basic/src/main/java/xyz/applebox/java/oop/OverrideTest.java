package xyz.applebox.java.oop;

import java.util.List;

public class OverrideTest {

    public static void main(String[] args) {
        List<Animal> animals = List.of(new Dog(), new Cat());
        for (Animal animal : animals) {
            animal.bark();
        }
    }

}

interface Animal {
    void bark();
}

class Dog implements Animal {
    @Override
    public void bark() {
        System.out.println("멍멍");
    }
}

class Cat implements Animal {
    @Override
    public void bark() {
        System.out.println("야옹");
    }
}