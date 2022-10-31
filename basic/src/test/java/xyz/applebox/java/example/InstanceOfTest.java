package xyz.applebox.java.example;

import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class InstanceOfTest {

    /**
     * JEP 394: Pattern Matching for instanceof
     * Release 16
     * instanceof 패턴 매칭을 지원하여 캐스팅이 필요없어졌습니다.
     */
    @Test
    void jep394() {
        List<Figure> figures = Arrays.asList(new Square(), new Circle(), new Square("네모"));
        for(Figure figure : figures) {
            if(figure instanceof Square square) {
                System.out.printf("이름: %s, line 수: %d%n", square.getName(), square.getLine());
            } else if(figure instanceof Circle circle) {
                System.out.printf("이름: %s%n", circle.getName());
            }
        }
    }

    @Test
    void jep394LogicalOperatorTest() {
        List<Number> numbers = List.of(30, 10.2642, 55, 2.73593, 33);

        for(Number number : numbers) {
//            if(number instanceof Integer i || i < 5) { }  // or 연산과 함께 사용할 수 없습니다.
            if(number instanceof Integer i && i % 10 == 0) {
                System.out.printf("정수> %d%n", i);
            } else if(number instanceof Double d && d.floatValue() > 10) {
                System.out.printf("실수> %f (약 %.1f)%n", d, d);
            }
        }
    }

    @Test
    void previousVersion() {
        List<Figure> figures = Arrays.asList(new Square(), new Circle(), new Square("네모"));
        for(Figure figure : figures) {
            if(figure instanceof Square) {
                Square square = (Square) figure;
                System.out.println(String.format("이름: %s, line 수: %d", square.getName(), square.getLine()));
            } else if(figure instanceof Circle) {
                Circle circle = (Circle) figure;
                System.out.println(String.format("이름: %s", circle.getName()));
            }
        }
    }

    @Getter
    abstract static class Figure {
        protected String name;
    }

    @Getter
    static class Circle extends Figure {
        public Circle() {
            this.name = "원";
        }
    }

    @Getter
    static class Square extends Figure {
        private final int line;

        public Square() {
            this.name = "사각형";
            this.line = 4;
        }
        public Square(String name) {
            this();
            this.name = name;
        }
    }
}
