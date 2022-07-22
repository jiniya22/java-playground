package xyz.applebox.java.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class BlockCipher {
    private static final SecretKeySpec keySpec;
    private static final AlgorithmParameterSpec ivSpec;
    static {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16], iv = new byte[16];
        random.nextBytes(key);
        random.nextBytes(iv);
        keySpec = new SecretKeySpec(key, "AES");
        ivSpec = new IvParameterSpec(iv);
    }

    public static void main(String[] args) {
        String data = "hello jiniworld!";
//        SealedObject encData = encryptWithSealedObject(data);
//        String decData = decryptWithSealedObject(encData);
        String encData = encrypt(data);
        String decData = decrypt(encData);
        System.out.println(encData);
        System.out.println(decData);
    }

    static String encrypt(String data) {
        try {
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            return new String(Base64.getEncoder().encode(cipher.doFinal(data.getBytes())));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String decrypt(String data) {
        try {
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data.getBytes())));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static SealedObject encryptWithSealedObject(String data) {
        try {
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            return new SealedObject(data, cipher);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String decryptWithSealedObject(SealedObject data) {
        try {
            return data.getObject(keySpec).toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
