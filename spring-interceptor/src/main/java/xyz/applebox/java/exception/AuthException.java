package xyz.applebox.java.exception;

public class AuthException extends RuntimeException {

    public AuthException() {
        super("인가되지 않은 사용자입니다.");
    }
}
