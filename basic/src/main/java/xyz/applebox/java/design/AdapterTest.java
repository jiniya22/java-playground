package xyz.applebox.java.design;

import org.junit.jupiter.api.Test;
import xyz.applebox.java.design.adapter.*;

class AdapterTest {

    @Test
    void test() {
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
//        connect(cleaner);
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);
        connect(new SocketAdapter(new AirConditioner()));
    }

    void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}