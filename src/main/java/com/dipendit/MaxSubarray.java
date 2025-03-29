package com.dipendit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaxSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3,4,-1,2,1,-5,4};
        System.out.println("Max: " + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int currSum = 0;

        for (int num : nums) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += num;
            if (maxSub < currSum) maxSub = currSum;
        }
        return maxSub;
    }

}
