package xyz.applebox.java.design;

import org.springframework.security.crypto.codec.Hex;

import java.util.Base64;

public class StrategyPattern {

    public static void main(String[] args) {
        String input = "jini@jiniworld.me";

        Encoder encoder = new Encoder(new Base64Strategy());
        System.out.println(encoder.encode(input));

        encoder.setEncodeStrategy(new HexStrategy());
        System.out.println(encoder.encode(input));
    }
}

class Encoder {
    private EncodeStrategy encodeStrategy;

    public Encoder(EncodeStrategy encodeStrategy) {
        this.encodeStrategy = encodeStrategy;
    }

    public String encode(String text) {
        return this.encodeStrategy.encode(text);
    }

    public void setEncodeStrategy(EncodeStrategy encodeStrategy) {
        this.encodeStrategy = encodeStrategy;
    }
}

interface EncodeStrategy {
    String encode(String text);
}

class Base64Strategy implements EncodeStrategy {
    @Override
    public String encode(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
}

class HexStrategy implements EncodeStrategy {
    @Override
    public String encode(String text) {
        return String.valueOf(Hex.encode(text.getBytes()));
    }
}