package com.dipendit.codeinterview;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numOfWorkers = 3;
        CountDownLatch latch = new CountDownLatch(numOfWorkers);

        //Creating 3 worker threads
        for (int i = 1; i <= numOfWorkers; i++) {
            new Thread(new Worker(latch, "Worker-" + i)).start();
        }

        System.out.println("Main thread waiting for workers to finish...");

        //Wait for all workers to finish
        latch.await();

        System.out.println("All workers have finished. Main thread continues.");

    }
}

class Worker implements Runnable {
    private CountDownLatch latch;
    private String name;

    public Worker(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is working...");
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println(name + " has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }
}