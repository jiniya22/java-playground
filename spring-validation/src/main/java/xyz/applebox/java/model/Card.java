package xyz.applebox.java.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record Card(
        @NotBlank
        String name,

        @JsonProperty("Type")
        @NotBlank
        String type,

        @JsonProperty("card_number")
        @NotBlank
        String cardNumber
) {
}
