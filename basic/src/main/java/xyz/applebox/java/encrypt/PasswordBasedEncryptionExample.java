package xyz.applebox.java.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class PasswordBasedEncryptionExample {

    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        char[] password = "password123!".toCharArray();
        byte[] salt = createSalt();
        byte[] iv = createIv();

        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, 1000, new IvParameterSpec(iv));
        SecretKey secretKey = getSecretKey(password);

        String encString = encrypt("jiniworld!", secretKey, paramSpec);
        System.out.println(encString);
        System.out.println(decrypt(encString, secretKey, paramSpec));
    }

    static String encrypt(String message, SecretKey secretKey, AlgorithmParameterSpec paramSpec) {
        try {
            Cipher cipher = Cipher.getInstance("PBEWithHmacSHA256AndAES_256");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            String result = Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes()));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String decrypt(String message, SecretKey secretKey, AlgorithmParameterSpec paramSpec) {
        try {
            Cipher cipher = Cipher.getInstance("PBEWithHmacSHA256AndAES_256");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(message)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static SecretKey getSecretKey(char[] password) {
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithHmacSHA256AndAES_256");
            return keyFactory.generateSecret(new PBEKeySpec(password));
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
