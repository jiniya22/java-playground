package xyz.applebox.java.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptExample {

    public static final BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2B, 12);

    public static void main(String[] args) {
        String rawPassword = "password2213@";
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        String encPassword2 = bCryptPasswordEncoder.encode(rawPassword);
        System.out.println(encPassword);
        System.out.println(encPassword2);
        System.out.println(bCryptPasswordEncoder.matches(rawPassword, encPassword));
        System.out.println(bCryptPasswordEncoder.matches(rawPassword, encPassword2));
    }
}

