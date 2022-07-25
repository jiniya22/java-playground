package xyz.applebox.java.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Sha256Encrypt {

    public static void main(String[] args) {
        String data = "hello jiniworld", data2 = "hello jiniworld!";

        System.out.println(encrypt(data));
        System.out.println(encrypt(data));
        System.out.println(encrypt(data2));
    }

    static String encrypt(String message) {
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(message.getBytes());
            return Base64.getEncoder().encodeToString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
