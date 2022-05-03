package xyz.applebox.java.example;

import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class InstanceOfExample {

    /**
     * JEP 394: Pattern Matching for instanceof
     * Release 16
     * instanceof 패턴 매칭을 지원하여 캐스팅이 필요없어졌습니다.
     */
    @Test
    void instanceofPatternMatchTest() {
        List<Figure> figures = Arrays.asList(new Square(), new Circle(), new Square("네모"));
        for(Figure figure : figures) {
            if(figure instanceof Square square) {
                System.out.println(String.format("이름: %s, line 수: %d", square.getName(), square.getLine()));
            } else if(figure instanceof Circle circle) {
                System.out.println(String.format("이름: %s", circle.getName()));
            }
        }
    }

    @Getter
    abstract class Figure {
        protected String name;
    }

    @Getter
    class Circle extends Figure {
        public Circle() {
            this.name = "원";
        }
    }

    @Getter
    class Square extends Figure {
        private int line;

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
