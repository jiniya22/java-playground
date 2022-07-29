package xyz.applebox.java.domain.value;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HmacTestValue {
    private String userId;
    private String name;

    public HmacTestValue(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
