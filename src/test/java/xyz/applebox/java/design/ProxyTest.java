package xyz.applebox.java.design;

import org.junit.jupiter.api.Test;
import xyz.applebox.java.design.proxy.AopBrowser;
import xyz.applebox.java.design.proxy.Browser;
import xyz.applebox.java.design.proxy.BrowserProxy;
import xyz.applebox.java.design.proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;

class ProxyTest {

    @Test
    void normal() {
        Browser browser = new Browser("jiniworld.me");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
    }

    @Test
    void proxy() {
        IBrowser browser = new BrowserProxy("jiniworld.me");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
    }

    @Test
    void aop() {
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser browser = new AopBrowser("jiniworld.me",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });
        browser.show();
        System.out.println("loading time " + end.get());
        browser.show();
        System.out.println("loading time " + end.get());
    }
}