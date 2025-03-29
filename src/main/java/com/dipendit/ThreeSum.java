package com.dipendit;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[] {-1,0,1,2,-1,-4});
        printList(res);

        res = threeSum(new int[]{0,1,1});
        printList(res);

        res = threeSum(new int[]{0,0,0});
        printList(res);
    }

    public static void printList(List<List<Integer>> res) {
        for (List<Integer> r : res) {
            System.out.println("[" + r.get(0) + ", " + r.get(1) + ", " + r.get(2) + "]");
        }
    }

    // WORKS. Best solution. Copied from leetcode YouTube
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // {-1,0,1,2,-1,-4}
        // {-4,-1,-1,0,1,2}
        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            if (i == 0 || ( nums[i] != nums[i-1])) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int threeSum = firstNum + nums[l] + nums[r];
                    if (threeSum > 0)
                        r--;
                    else if (threeSum < 0)
                        l++;
                    else {
                        res.add(List.of(firstNum, nums[l], nums[r]));
                        l++;
                        while (l < r && nums[l] == nums[l-1])
                            l++;
                    }
                }
            }
        }

        return res;
    }

    //WORKED -but not submitted
    public static List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        // {-1,0,1,2,-1,-4}
        for (int i = 0; i < nums.length; i++) {
            int twoSumT = -nums[i];

            Map<Integer, Integer> foundMap = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int t = twoSumT - nums[j];
                if (foundMap.containsKey(t)) {
                    List<Integer> tl = Arrays.asList(nums[i], t, nums[j]);
                    Collections.sort(tl);
                    if (!res.contains(tl))
                        res.add(tl);
                } else {
                    foundMap.put(nums[j], j);
                }
            }
        }
        return res;
    }

}
