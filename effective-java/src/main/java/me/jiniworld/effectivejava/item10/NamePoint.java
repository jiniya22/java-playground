package me.jiniworld.effectivejava.item10;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class NamePoint extends Point {
    private final String name;

    public NamePoint(int x, int y, String name) {
        super(x, y);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof NamePoint p) {
            return super.equals(p) && this.name.equals(p.name);
        }
        return false;
    }
}
