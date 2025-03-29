package com.dipendit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductOfArray {
    public static void main(String[] args) {
        //int[] res = productExceptSelf(new int[] {1, 2, 3, 4});
        int[] res = productExceptSelf(new int[] {-1,1,0,-3,3});

        System.out.print("Result: [");
        IntStream.range(0, res.length)
                        .forEach(i -> System.out.print(res[i] + ((i < res.length - 1) ? " ," : "")));
        System.out.println("]");

/*
        System.out.print("Result: [");
        System.out.print(
            Arrays.stream(res)
                  .boxed()
                  .map(String::valueOf)
                  .collect(Collectors.joining(", ")));
        System.out.println("]");
*/

/*
        List<Integer> resList = Arrays.stream(res)
                                      .boxed()
                                      .toList();
*/
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int runProd = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = runProd;
            runProd *= nums[i];
        }

        runProd = 1;
        for (int j = nums.length-1; j >= 0; j--) {
            res[j] *= runProd;
            runProd *= nums[j];
        }

        return res;
    }
}
