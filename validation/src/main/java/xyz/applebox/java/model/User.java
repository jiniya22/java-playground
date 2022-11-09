package xyz.applebox.java.model;

import javax.validation.constraints.*;
import java.time.format.DateTimeFormatter;

public record User(
        @NotBlank
        String name,

        @Min(1) @Max(150)
        int age,

        @Email
        String email,

        @Pattern(regexp = "^01[01679]-\\d{3,4}-\\d{4}$")
        String phone,

        String month
) {

        @AssertTrue(message = "yyyyMM 형식에 맞지 않습니다")
        public boolean isMonthValidation() {
                try {
                        java.time.YearMonth.parse(this.month, DateTimeFormatter.ofPattern("yyyyMM"));
                } catch (Exception e) {
                        return false;
                }
                return true;
        }
}
