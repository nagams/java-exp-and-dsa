package com.dipendit.concurrency;

public class SleepMessages {
    public static void main(String[] args) throws InterruptedException {
        String[] impInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (String msg : impInfo) {
            //Pause for 4 seconds
            Thread.sleep(4000);
            System.out.println(msg);
        }
    }
}
