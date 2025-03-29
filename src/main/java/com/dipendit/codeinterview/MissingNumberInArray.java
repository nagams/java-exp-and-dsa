package com.dipendit.codeinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingNumberInArray {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {6, 2, 4, 5, 1}));
        System.out.println(missingNumber(new int[] {6, 2, 4, 5, 1}, 6));
    }

    public static int missingNumber(int[] nums) {

/*
        //This method creates immutable list
        List<Integer> numsList = Arrays.stream(nums)
                                        .boxed()
                                        .toList();
*/
        List<Integer> numsList = new ArrayList<>();
        for (int n : nums)
            numsList.add(n);
        Collections.sort(numsList);
        int prvN = -1;
        for (int n : numsList) {
            if (prvN != -1) {
                if (n != prvN + 1)
                    return n - 1;
            } else
                prvN = n;
        }
        return -1;
    }

    public static int missingNumber(int[] nums, int n) {
        int sum = n * (n + 1) / 2;
        int arrSum = 0;
        for (int num : nums)
            arrSum += num;

        return sum - arrSum;
    }
}
