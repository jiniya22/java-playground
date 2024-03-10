package me.jiniworld.effectivejava.item14;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BigDecimalExample {

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1.0");
        BigDecimal b2 = new BigDecimal("1.00");
        System.out.println(b1.equals(b2));      // false
        System.out.println(b1.compareTo(b2));   // 0

        Set<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(b1);
        hashSet.add(b2);
        System.out.println(hashSet);    // [1.0, 1.00]
        Set<BigDecimal> treeSet = new TreeSet<>();
        treeSet.add(b1);
        treeSet.add(b2);
        System.out.println(treeSet);    // [1.0]
    }
}
