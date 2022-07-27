package xyz.applebox.java.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class AesExample {
    private static final SecureRandom random = new SecureRandom();
    private static final SecretKeySpec secretKeySpec = new SecretKeySpec("RRkZlu+gbLxrwYEyzB+yYQ==".getBytes(), "AES");

    public static void main(String[] args) {
        String data = "hello jiniworld!";
        byte[] iv = createIv();

        AlgorithmParameterSpec parameterSpec = new IvParameterSpec(iv);
        String encData = encrypt(data, parameterSpec);
        String decData = decrypt(encData, parameterSpec);
        System.out.println(encData);
        System.out.println(decData);
    }

    static byte[] createIv() {
        byte[] iv = new byte[16];
        random.nextBytes(iv);
        return iv;
    }

    static String encrypt(String data, AlgorithmParameterSpec parameterSpec) {
        try {
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, parameterSpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String decrypt(String data, AlgorithmParameterSpec parameterSpec) {
        try {
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, parameterSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
