package xyz.applebox.batch.part3;

public class NotFoundNameException extends RuntimeException {
  public NotFoundNameException() {
    super("이름이 설정되어있지 않습니다.");
  }
}
