package me.jiniworld.effectivejava.item14;

import org.jetbrains.annotations.NotNull;

public record Member(
    String name, int age
) implements Comparable<Member> {
    @Override
    public int compareTo(@NotNull Member m) {
        int result = Integer.compare(age, m.age);
        if(result == 0) {
            return name.compareTo(m.name);
        }
        return result;
    }
}
