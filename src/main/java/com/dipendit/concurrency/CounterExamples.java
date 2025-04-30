package com.dipendit.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CounterExamples {
    public static void main(String[] args) {
        int threadCount = 10;
        ExecutorService service = Executors.newFixedThreadPool(threadCount);

        Counter counter = new Counter();
//        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            service.execute(() -> {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " - Count: "  + counter.getCount());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.out.println("In MAIN --->");
        service.shutdown();

        try {
            if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Forcing shutdown...");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        atomicIntegerExample();
    }

    public static void atomicIntegerExample() {
        ExecutorService service = Executors.newFixedThreadPool(10);

        AtomicCounter counter = new AtomicCounter();
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                counter.increment();
                System.out.println(counter.getCounter());
            });
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("In MAIN-2 ---->");
        service.shutdown();

        try {
            if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Force shoutdown...");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
