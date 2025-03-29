package com.dipendit.concurrency;

public class SimpleThreads {

    static void threadMessage(String message) {
        System.out.format("%s: %s%n",
                Thread.currentThread().getName(),
                message);
    }

    private static class MessageLoop implements Runnable {
        @Override
        public void run() {
            String[] impInfo = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };

            for (String msg : impInfo) {
                //Pause for 4 seconds
                try {
                    Thread.sleep(4000);
                    threadMessage(msg);
                } catch (InterruptedException e) {
                    threadMessage("I wasn't done!");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long patience = 1000 * 60 * 60;

        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        while (t.isAlive()) {
            threadMessage("Still waiting...");

            // Wait maximum of 1 second for
            // MessageLoop thread to finish
            t.join(1000);

            if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}
