package xyz.applebox.java.oop;

public class OverloadTest {

    public static void main(String[] args) {
        PlusTest plusTest = new PlusTest();

        System.out.println(PlusTest.plus(3, 2));
        System.out.println(PlusTest.plus(13, 1, 5));
        System.out.println(PlusTest.plus(13.7, 4.3));
    }
}

class PlusTest {
    static int plus(int a, int b) {
        return a + b;
    }

    static int plus(int a, int b, int c) {
        return a + b + c;
    }

    static double plus(double a, double b) {
        return a + b;
    }
}
