package xyz.applebox.java.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

@SpringBootTest
class VarTest {


    /**
     * JEP 286: Local-Variable Type Inference
     * Release 10
     * local 변수인 var 를 지원합니다.<br>
     * 컴파일러에서 var 변수 타입을 결정해줍니다.
     */
    @Test
    void jep286() {
        var name = "coco";
        var list = Arrays.asList("apple", "melon");
        System.out.println(name.getClass());
        System.out.println(list.getClass());
    }

    /**
     * JEP 323: Local-Variable Syntax for Lambda Parameters
     * Release 11
     * 람다 표현식에서
     */
    @Test
    void jep323() {
        var list = Arrays.asList(32, 1, 10, 5, 29, 11, 48);
        System.out.println(list.stream().filter((var item) -> item > 10).collect(Collectors.toList()));

        IntFunction<Integer> powFunction = (var num) -> num * num;
        System.out.println(powFunction.apply(3));
    }

}