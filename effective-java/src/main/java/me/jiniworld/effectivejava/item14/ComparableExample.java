package me.jiniworld.effectivejava.item14;

import org.assertj.core.util.Lists;

import java.util.Collections;
import java.util.List;

public class ComparableExample {

    public static void main(String[] args) {
        List<Member> members = Lists.newArrayList(new Member("jini", 33),
            new Member("lily", 28), new Member("sol", 39), new Member("coco", 28));
        Collections.sort(members);
        System.out.println(members);
    }
}
