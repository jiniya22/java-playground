package me.jiniworld.effectivejava.item61;

import java.util.List;

public class Item63 {
    public static void main(String[] args) {
        String s1 = "apple";
        String s2 = "tree";
        String result = s1 + s2;
        System.out.println(result);

        System.out.println("=====");

        System.out.println(ex01(List.of(s1, s2)));
    }

    static String ex01(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
        }
        return builder.toString();
    }
}
