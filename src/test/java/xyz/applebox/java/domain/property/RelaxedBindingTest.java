package xyz.applebox.java.domain.property;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RelaxedBindingTest {

    @Autowired
    private RelaxedBinding relaxedBinding;

    @Test
    void test() {
        System.out.println(relaxedBinding);
    }

}