package xyz.applebox.java.encrypt;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class Pbkdf2PasswordEncoderExample {
    private static final CharSequence SECRET_KEY = "mySecretKey1123!";
    private static final int ITERATION_COUNT = 65536;
    private static final int HASH_WIDTH = 256;
    private static final int SALT_LENGTH = 16;
    public static Pbkdf2PasswordEncoder pbkdf2PasswordEncoder;

    static {
        pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder(SECRET_KEY, SALT_LENGTH, ITERATION_COUNT, HASH_WIDTH);
        pbkdf2PasswordEncoder.setAlgorithm(Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
        pbkdf2PasswordEncoder.setEncodeHashAsBase64(true);
    }

    public static void main(String[] args) {
        String rawPassword = "pass0rd2213@";
        String encPassword = pbkdf2PasswordEncoder.encode(rawPassword);
        String encPassword2 = pbkdf2PasswordEncoder.encode(rawPassword);
        System.out.println(encPassword);
        System.out.println(encPassword2);
        System.out.println(pbkdf2PasswordEncoder.matches(rawPassword, encPassword));
        System.out.println(pbkdf2PasswordEncoder.matches(rawPassword, encPassword2));
    }
}
