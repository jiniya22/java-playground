package me.jiniworld.effectivejava.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex2 {
    private static final String[] P_VALUES = {"apple", "melon", "peach"};
    public static final List<String> VALUES = List.of(P_VALUES);

    public static final String[] fruits() {
        return P_VALUES.clone();
    }

    public static void main(String[] args) {
        System.out.println(VALUES);
//        VALUES.set(0, "AAA"); // Exception 발생
        System.out.println("-------");

        String[] fruits = fruits();
        System.out.println(Arrays.toString(fruits));    // [apple, melon, peach]
        fruits[0] = "AAA";
        System.out.println(Arrays.toString(fruits));    // [AAA, melon, peach]
        System.out.println(Arrays.toString(fruits()));  // [apple, melon, peach]
    }

}
