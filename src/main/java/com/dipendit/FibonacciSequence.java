package com.dipendit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibonacciSequence {

    private static final Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        //0 1 1 2 3 5 8 ...
        System.out.print("Fibonacci Sequence: ");
        long st = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
        long et = System.currentTimeMillis();
        System.out.println("Time taken: " + (et-st));

        System.out.print("Memo Fibonacci Sequence: ");
        st = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            System.out.print(memoFib(i) + " ");
        }
        System.out.println();
        et = System.currentTimeMillis();
        System.out.println("Time taken: " + (et-st));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static int memoFib(int n) {
        if (n <= 1) {
            return n;
        } else {
            if (!memo.containsKey(n)) {
                memo.put(n, memoFib(n-1) + memoFib(n-2));
            }
            return memo.get(n);
        }
    }
}
