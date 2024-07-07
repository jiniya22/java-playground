package me.jiniworld.effectivejava.item17;

import lombok.Getter;

@Getter
public class Complex {
    private double re;
    private double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }
}
