package xyz.applebox.java.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class AesExampleUsingSealedObject {
    private static final SecureRandom random = new SecureRandom();
    private static final SecretKeySpec keySpec = new SecretKeySpec("RRkZlu+gbLxrwYEyzB+yYQ==".getBytes(), "AES");

    public static void main(String[] args) {
        String data = "hello jiniworld!";
        SealedObject encData = encrypt(data);
        String decData = decrypt(encData);
        System.out.println(encData);
        System.out.println(decData);
    }

    static AlgorithmParameterSpec createIvParameterSpec() {
        byte[] iv = new byte[16];
        random.nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    static SealedObject encrypt(String data) {
        try {
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, createIvParameterSpec());
            return new SealedObject(data, cipher);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String decrypt(SealedObject data) {
        try {
            return data.getObject(keySpec).toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
