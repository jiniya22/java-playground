package xyz.applebox.java.design.decorator;

import org.junit.jupiter.api.Test;

import java.util.List;

class DecoratorTest {

    @Test
    void test() {
        ICar iCar = new Audi(1000);
        List<ICar> cars = List.of(iCar, new A3(iCar), new A4(iCar), new A5(iCar));
        for (ICar i : cars) {
            i.showPrice();
        }
    }
}