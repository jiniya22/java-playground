package xyz.applebox.java.model;

import xyz.applebox.java.annotation.YearMonth;

import javax.validation.constraints.*;

public record User(
        @NotBlank
        String name,

        @Min(1) @Max(150)
        int age,

        @Email
        String email,

        @Pattern(regexp = "^01[01679]-\\d{3,4}-\\d{4}$")
        String phone,

        @YearMonth
        String month
) {
}
