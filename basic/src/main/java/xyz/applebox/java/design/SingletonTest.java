package xyz.applebox.java.design;

import org.junit.jupiter.api.Test;

class SingletonTest {

    @Test
    void test() {
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        Singleton aContent = aClazz.getContent();
        Singleton bContent = bClazz.getContent();

        System.out.println(aContent.equals(bContent));
    }

    static class AClazz {
        private Singleton content;
        public AClazz() {
            this.content = Singleton.getInstance();
        }
        public Singleton getContent() {
            return this.content;
        }
    }

    static class BClazz {
        private Singleton content;
        public BClazz() {
            this.content = Singleton.getInstance();
        }
        public Singleton getContent() {
            return this.content;
        }
    }

}