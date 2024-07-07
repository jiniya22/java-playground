package me.jiniworld.effectivejava.item15;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        ex01();
        System.out.println("---------");
        ex02();
    }


    private static final String[] arr = {"apple"};
    static void ex01() {
        System.out.println(Arrays.toString(arr));   // [apple]
        arr[0] = "banana";
        System.out.println(Arrays.toString(arr));   // [banana]
    }
    private static final List<String> list = Lists.newArrayList("RED", "BLUE");
    static void ex02() {
        System.out.println(list);
        list.set(0, "AAA");
        System.out.println(list);
    }
}
