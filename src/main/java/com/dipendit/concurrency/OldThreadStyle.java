package com.dipendit.concurrency;

public class OldThreadStyle {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        t1.start();

        new Thread( () -> {
            System.out.println("In thread-2");
        }).start();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("In thread " + this.hashCode());
    }
}
