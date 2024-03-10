package me.jiniworld.effectivejava.item10;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.*;

@Getter
@RequiredArgsConstructor
public class ColorPoint {
    private final Color color;
    private final Point point;

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ColorPoint cp) {
            return this.point.equals(cp.point) && this.color.equals(cp.color);
        }
        return false;
    }
}
