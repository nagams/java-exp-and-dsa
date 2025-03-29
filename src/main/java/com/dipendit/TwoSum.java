package com.dipendit;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
//        int[] res = findTwoSum(new int[]{2, 7, 11, 15}, 9);
//        int[] res = findTwoSum(new int[]{3, 2, 4}, 6);
        int[] res = findTwoSum(new int[]{3, 3}, 6);
        if (res.length > 0)
            System.out.println("Ans: [" + res[0] + ", " + res[1] + "]");

    }

    //nums = [2,7,11,15], target = 9
    //[0,1]
    public static int[] findTwoSum(int[] nums, int t) {
        Map<Integer, String> occs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            occs.merge(nums[i], String.valueOf(i), (oldVal, newVal) -> oldVal.concat(",").concat(newVal));
        }
        System.out.println(occs);

        int i = 0;
        while ( i < nums.length ) {
            int le = nums[i];
            int re = t-le;
            if (occs.containsKey(re)) {
                String val = occs.get(re);
                String[] indices = val.split(",");
                if (indices.length > 1) {
                    for (String re_is : indices) {
                        int re_i = Integer.parseInt(re_is);
                        if (i != re_i)
                            return new int[]{i, re_i};
                    }
                } else {
                    int re_i = Integer.parseInt(indices[0]);
                    if (i != re_i)
                        return new int[]{i, re_i};
                }
            }
            i++;
        }
        return new int[]{};
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        int y = 0, yi = 0;
        for (int i = 0; i < nums.length; i++) {
            y = target - nums[i];
            if (numsMap.containsKey(y)) {
                yi = numsMap.get(y);
                res[0] = yi;
                res[1] = i;
                return res;
            } else {
                numsMap.put(nums[i], i);
            }
        }
        return res;
    }
}
