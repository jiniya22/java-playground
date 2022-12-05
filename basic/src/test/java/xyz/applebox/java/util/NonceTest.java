package xyz.applebox.java.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class NonceTest {

    @DisplayName("1. Random 클래스를 이용한 5자리수의 nonce 50개 생성")
    @Test
    void test1() {
        for(int i=0; i< 50; i++) {
            System.out.println(createNonce(5));
        }
    }

    /**
     * numberOfDigits 자리 수인 랜덤 값을 생성
     * @param numberOfDigits
     * @return nonce
     */
    int createNonce(int numberOfDigits) {
        Random random = new Random();
        int high = (int)Math.pow(10, numberOfDigits);
        int low = (int)Math.pow(10, numberOfDigits - 1);

        int nonce = random.nextInt(high) + low;
        if (nonce > high) {
            nonce = nonce - low;
        }
        return nonce;
    }
}