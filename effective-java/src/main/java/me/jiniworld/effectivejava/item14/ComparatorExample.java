package me.jiniworld.effectivejava.item14;

import org.assertj.core.util.Lists;

import java.util.*;

public class ComparatorExample {

    public static void main(String[] args) {
        List<Student> students = Lists.newArrayList(new Student("jini", 33),
            new Student("lily", 28), new Student("sol", 39), new Student("coco", 28));
        Collections.sort(students, COMPARATOR);
        System.out.println(students);
    }

    static final Comparator<Student> COMPARATOR = Comparator
        .comparingInt((Student s) -> s.age())
        .thenComparing(s -> s.name());


}
