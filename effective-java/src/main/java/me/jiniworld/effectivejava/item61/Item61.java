package me.jiniworld.effectivejava.item61;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Item61 {
    static Integer i;

    public static void main(String[] args) {
//        if(i != 10)
//            System.out.println("이게 출력될까요?");
    }

    static Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

    static void ex01() {
        List<Integer> nums = new ArrayList<>();
        nums.addAll(List.of(5, 4, 9, 1, 100, 50));
        System.out.println(nums);
        nums.sort(naturalOrder);
        System.out.println(nums);
    }


}
