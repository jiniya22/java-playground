package xyz.applebox.java.model;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

public record Member(

        @NotBlank
        String name,

        @Min(1) @Max(150)
        int age,

        @Valid
        List<Card> cards
) {
}
