package com.dipendit.codeinterview;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchCallableExample {
    public static void main(String[] args) throws InterruptedException {
        int numOfWorkers = 3;
        CountDownLatch latch = new CountDownLatch(numOfWorkers);
        CountDownLatch startLatch = new CountDownLatch(1);

        ExecutorService exService = Executors.newFixedThreadPool(numOfWorkers);

        //Creating 3 worker threads
        for (int i = 1; i <= numOfWorkers; i++) {
            Callable<String> cw = new CallWorker(latch, "Worker-" + i, startLatch);
            exService.submit(cw);
        }

        System.out.println("Main thread waiting for workers to finish...");
        startLatch.countDown();

        //Wait for all workers to finish
        latch.await();
        exService.shutdown();

        System.out.println("All workers have finished. Main thread continues.");

    }
}

class CallWorker implements Callable {
    private CountDownLatch latch;
    private CountDownLatch startLatch;
    private String name;

    public CallWorker(CountDownLatch latch, String name, CountDownLatch startLatch) {
        this.latch = latch;
        this.name = name;
        this.startLatch = startLatch;
    }

    @Override
    public String call() {
        try {
            System.out.println("Before startLatch await: " + name);
            startLatch.await();
            System.out.println(name + " is working...");
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println(name + " has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
        return name;
    }
}