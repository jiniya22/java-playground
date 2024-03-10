package me.jiniworld.effectivejava.item10;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Point point = new Point(2, 3);
        NamePoint namePoint = new NamePoint(2, 3, "coco");
        System.out.println(point.equals(namePoint));
        System.out.println(namePoint.equals(point));
    }
}