package xyz.applebox.java.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class Pbkdf2Encrypt {
    private static final String keyPassword = "1gy0WLGTQLDFVfHT0uQT26MAXbObgPJR9/6nC4zwxgU=";
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        final byte[] salt = createSalt();
        AlgorithmParameterSpec ivSpec = createIvParameterSpec();
        String enc1 = encrypt("jiniworld !", salt, ivSpec);
        String enc2 = encrypt("jiniworld !", salt, ivSpec);
        System.out.println(enc1);
        System.out.println(decrypt(enc1, salt, ivSpec));
        System.out.println(enc2);
        System.out.println(decrypt(enc2, salt, ivSpec));
    }

    static String encrypt(String message, byte[] salt, AlgorithmParameterSpec ivSpec) {
        try {
            final SecretKeySpec secretKeySpec = getSecretKeySpec(salt);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);
            String result = Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes()));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String decrypt(String message, byte[] salt, AlgorithmParameterSpec ivSpec) {
        try {
            final SecretKeySpec secretKeySpec = getSecretKeySpec(salt);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(message)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static byte[] createSalt() {
        byte[] salt = new byte[32];
        random.nextBytes(salt);
        return salt;
    }

    static AlgorithmParameterSpec createIvParameterSpec() {
        byte[] iv = new byte[16];
        random.nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    static SecretKeySpec getSecretKeySpec(byte[] salt) {
        try {
            final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            return new SecretKeySpec(
                    keyFactory.generateSecret(new PBEKeySpec(keyPassword.toCharArray(), salt, 65536, 256)).getEncoded(), "AES");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
