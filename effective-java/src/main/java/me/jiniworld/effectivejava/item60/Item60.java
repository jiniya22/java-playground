package me.jiniworld.effectivejava.item60;

import ch.qos.logback.core.util.TimeUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Item60 {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        ex01();
        System.out.println(LocalDateTime.now());
        ex02();
        System.out.println(LocalDateTime.now());
        ex03();
        System.out.println(LocalDateTime.now());

    }

    private static void ex01() {
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);
    }

    private static void ex02() {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);
    }

    private static void ex03() {
        int funds = 100;
        int itemsBought = 0;
        for (int price = 10; funds >= price; price += 10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: " + funds + " cents");
    }
}
