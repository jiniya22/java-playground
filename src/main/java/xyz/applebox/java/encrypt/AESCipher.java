package xyz.applebox.java.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class AESCipher {
    private static final SecureRandom random = new SecureRandom();
    private static final SecretKeySpec keySpec = new SecretKeySpec("RRkZlu+gbLxrwYEyzB+yYQ==".getBytes(), "AES");

    public static void main(String[] args) {
        String data = "hello jiniworld!";
        AlgorithmParameterSpec ivSpec = createIvParameterSpec();
        String encData = encrypt(data, ivSpec);
        String decData = decrypt(encData, ivSpec);
        System.out.println(encData);
        System.out.println(decData);
    }

    static AlgorithmParameterSpec createIvParameterSpec() {
        byte[] iv = new byte[16];
        random.nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    static String encrypt(String data, AlgorithmParameterSpec ivSpec) {
        try {
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String decrypt(String data, AlgorithmParameterSpec ivSpec) {
        try {
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
