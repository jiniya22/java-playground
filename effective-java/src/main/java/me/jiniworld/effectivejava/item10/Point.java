package me.jiniworld.effectivejava.item10;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
public class Point {
    private final int x;
    private final int y;
}
