package xyz.applebox.java.encrypt;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class Pbkdf2Example {
    private static final SecureRandom random = new SecureRandom();
    private static final byte[] SECRET_KEY = "mySecretKey1123!".getBytes();
    private static final int ITERATION_COUNT = 65536;
    private static final int HASH_WIDTH = 256;
    private static final int SALT_LENGTH = 16;

    public static void main(String[] args) {
        String rawPassword = "pass0rd2213@";

        String encString = encode(rawPassword);
        String encString2 = encode(rawPassword);

        System.out.println(encString);
        System.out.println(encString2);
        System.out.println(matches(rawPassword, encString));
        System.out.println(matches(rawPassword, encString2));
        System.out.println(matches(rawPassword, "PwFaWOHBeetzCFKy+U8fZg4cxCTZlHNu6rngeYhYl9+QAXHClbP5Q+dC2X+9fJOQ"));
    }

    public static String encode(CharSequence rawPassword) {
        byte[] salt = createSalt();
        byte[] encoded = encode(rawPassword, salt);
        return Base64.getEncoder().encodeToString(encoded);
//        return String.valueOf(Hex.encode(encoded));
    }

    private static byte[] encode(CharSequence rawPassword, byte[] salt) {
        try {
            PBEKeySpec spec = new PBEKeySpec(rawPassword.toString().toCharArray(),
                    concatenate(salt, SECRET_KEY), ITERATION_COUNT, HASH_WIDTH);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            return concatenate(salt, skf.generateSecret(spec).getEncoded());
        } catch (GeneralSecurityException ex) {
            throw new IllegalStateException("Could not create hash", ex);
        }
    }

    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        byte[] digested = Base64.getDecoder().decode(encodedPassword);
//        byte[] digested = Hex.decode(encodedPassword);
        byte[] salt = new byte[SALT_LENGTH];
        System.arraycopy(digested, 0, salt, 0, SALT_LENGTH);    // deep copy
        return MessageDigest.isEqual(digested, encode(rawPassword, salt));
    }

    static byte[] createSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    public static byte[] concatenate(byte[]... arrays) {
        int length = 0;
        for (byte[] array : arrays) {
            length += array.length;
        }
        byte[] newArray = new byte[length];
        int destPos = 0;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, newArray, destPos, array.length);
            destPos += array.length;
        }
        return newArray;
    }

}
