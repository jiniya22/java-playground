package me.jiniworld.modern.sort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortExample {

    @ToString
    @Getter
    @AllArgsConstructor
    public static class Item {
        private String name;
        private Integer cost;
    }

    public static void main(String[] args) {

        List<Item> items = Arrays.asList(new Item("아메리카노", 4500), new Item("아포가토", 5800),
            new Item("카페라떼", 5000), new Item("얼그레이", 4100), new Item("카푸치노", 5200));

        System.out.println(items);
//        items.sort((Item i1, Item i2) -> i1.getCost().compareTo(i2.getCost()));
        items.sort(Comparator.comparing(Item::getCost));
        System.out.println(items);
    }
}
