package com.dipendit;

public class MinInRotatedSorted {
    public static void main(String[] args) {
        System.out.println("Min: " + findMin(new int[] {3,4,5,1,2}));
        System.out.println("Min: " + findMin(new int[] {4,5,6,7,0,1,2}));
        System.out.println("Min: " + findMin(new int[] {11,13,15,17}));
    }

    //BETTER -using binary search algorithm. It is known for logn time complexity
    public static int findMin(int[] nums) {
        int res = nums[0];

        int l = 0, r = nums.length - 1, m;
        while (l < r) {
            if (nums[r] > nums[l])
                return Math.min(res, nums[l]);
            m = (l + r) / 2;
            res = Math.min(res, nums[m]);
            if (nums[m] > nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }

    //WORKS
    public static int findMin2(int[] nums) {
        //3,4,5,1,2
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
            if (i == 0) {
                if (nums[nums.length-1] > nums[i] && nums[0] < nums[1])
                    return nums[0];
            } else if (i == nums.length - 1) {
                if (nums[i-1] > nums[i] && nums[i] < nums[0])
                    return nums[i];
            } else {
                if (nums[i-1] > nums[i] && nums[i] < nums[i+1])
                    return nums[i];
            }
        }
        return -1;
    }

}
