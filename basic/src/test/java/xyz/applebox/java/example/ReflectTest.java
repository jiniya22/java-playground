package xyz.applebox.java.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectTest {

    @Test
    void test1() throws ClassNotFoundException {
        Class clazz = Class.forName("xyz.applebox.java.util.GsonUtils");

        for (Constructor c : clazz.getConstructors()) {
            System.out.println(c);
        }
        System.out.println();
        for (Method m : clazz.getMethods()) {
            System.out.println(m);
        }
    }

    @Test
    void test2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName("xyz.applebox.java.example.User");

        User user1 = (User) clazz.getDeclaredConstructor().newInstance();
        user1.setName("coco");
        user1.setAge(22);
        System.out.println(user1);

        User user2 = (User) clazz.getDeclaredConstructor(String.class, Integer.TYPE)
                .newInstance("sol", 33);
        System.out.println(user2);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private String name;
    private int age;
}