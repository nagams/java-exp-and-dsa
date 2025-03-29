package com.dipendit;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println("Sum: " + getSum(11, 11));
    }

    public static int getSum(int a, int b) {
        int i = 0;
        int temp;

        while (b != 0) {
            temp = a;
            a = a ^ b;
            b = temp & b;
            b = b << 1;
            System.out.println("Loop: " + i++);
        }

        return a;
    }

}
