package com.dipendit;

public class NumberOfOneBits {
    public static void main(String[] args) {
        System.out.println("Count: " + hammingWeight(11));
        System.out.println("Count: " + hammingWeight2(11));
    }

    public static int hammingWeight(int n) {
        int count=0;

        while (n > 0) {
            count += n % 2;
            n >>= 1;
        }

        return count;
    }

    public static int hammingWeight2(int n) {
        int count=0;

        while (n > 0) {
            n = n & (n-1);
            count++;
        }

        return count;
    }
}
