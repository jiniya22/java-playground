package xyz.applebox.java.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class Pbkdf2Example {

    private static final SecureRandom random = new SecureRandom();
    private static final int ITERATION_COUNT = 1000;
    private static final int KEY_LENGTH = 256;

    public static void main(String[] args) {
        char[] password = "password123!".toCharArray();
        byte[] salt = createSalt();
        byte[] iv = createIv();

        SecretKeySpec secretKeySpec = getSecretKeySpec(password, salt);
        AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);

        String encString = encrypt("jiniworld!", secretKeySpec, paramSpec);
        String decString = decrypt(encString, secretKeySpec, paramSpec);
        System.out.println(encString);
        System.out.println(decString);
    }

    static String encrypt(String message, SecretKeySpec secretKeySpec, AlgorithmParameterSpec paramSpec) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, paramSpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String decrypt(String message, SecretKeySpec secretKeySpec, AlgorithmParameterSpec paramSpec) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, paramSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(message)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static SecretKeySpec getSecretKeySpec(char[] password, byte[] salt) {
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            return new SecretKeySpec(keyFactory.generateSecret(new PBEKeySpec(password, salt, ITERATION_COUNT, KEY_LENGTH)).getEncoded(), "AES");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static byte[] createSalt() {
        byte[] salt = new byte[32];
        random.nextBytes(salt);
        return salt;
    }

    static byte[] createIv() {
        byte[] iv = new byte[16];
        random.nextBytes(iv);
        return iv;
    }

}
