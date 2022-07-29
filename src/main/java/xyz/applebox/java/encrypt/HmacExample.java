package xyz.applebox.java.encrypt;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HmacExample {
    private static final String ALGORITHM = "HmacSHA256";
    private static final SecretKeySpec SECRET_KEY_SPEC;
    static {
        SECRET_KEY_SPEC = new SecretKeySpec("secretKe!y@@98".getBytes(), ALGORITHM);
    }

    public static void main(String[] args) {
        String message = "hello jiniworld", message2 = "hello jiniworld!";;
        System.out.println(encrypt(message));
        System.out.println(encrypt(message));
        System.out.println(encrypt(message2));
    }

    static String encrypt(String message) {
        try {
            Mac mac = Mac.getInstance(ALGORITHM);
            mac.init(SECRET_KEY_SPEC);
            mac.update(message.getBytes());
            return Base64.getEncoder().encodeToString(mac.doFinal(message.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
