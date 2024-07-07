package me.jiniworld.effectivejava.item18;

import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ex1();
        System.out.println("--------");
        ex2();
    }

    static void ex1() {
        InstrumentedHashSet<Integer> s = new InstrumentedHashSet<>();
        s.add(3);
        s.addAll(List.of(5, 6, 8));
        System.out.println(s.getAddCount());
    }

    static void ex2() {
        InstrumentedSet<Integer> s = new InstrumentedSet<>(new HashSet<>());
        s.add(3);
        s.addAll(List.of(5, 6, 8));
        System.out.println(s.getAddCount());
    }
}
