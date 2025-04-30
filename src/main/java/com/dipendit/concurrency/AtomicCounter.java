package com.dipendit.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private final AtomicInteger counter = new AtomicInteger(0);

    public int getCounter() {
        return counter.get();
    }

    public void increment() {
        counter.incrementAndGet();
    }
}
