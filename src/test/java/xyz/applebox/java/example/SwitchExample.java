package xyz.applebox.java.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SwitchExample {

    /**
     * JEP 361: Switch Expressions
     * Release 14
     * switch 문에서 -> 를 지원합니다.
     */
    @Test
    void jep361(){
        List<Animal> animals = Arrays.asList(Animal.CAT, Animal.CAT, Animal.LION, Animal.SNAKE, Animal.DUCK);
        animals.stream().forEach(animal -> {
            int legs = switch (animal) {
                case CAT, LION -> 4;
                case DUCK -> {
                    System.out.println("오리는 꽥꽥");
                    yield 2;
                }
                default -> 0;
            };
            System.out.println(String.format("%s의 다리개수는 %d", animal.name(), legs));
        });
    }

    @Test
    void previous(){
        List<Animal> animals = Arrays.asList(Animal.CAT, Animal.CAT, Animal.LION, Animal.SNAKE, Animal.DUCK);

        animals.stream().forEach(animal -> {
            int legs;
            switch (animal) {
                case CAT: case LION:
                    legs = 4;
                    break;
                case DUCK:
                    System.out.println("오리는 꽥꽥");
                    legs = 2;
                    break;
                default:
                    legs = 0;
                    break;
            };
            System.out.println(String.format("%s의 다리개수는 %d", animal.name(), legs));
        });
    }

    enum Animal {
        CAT, DUCK, LION, SNAKE
    }
}