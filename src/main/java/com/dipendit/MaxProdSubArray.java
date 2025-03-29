package com.dipendit;

public class MaxProdSubArray {
    public static void main(String[] args) {
        System.out.println("Res: " + maxProduct(new int[] {-2,0,-1}));
        //3,-1,4
        System.out.println("Res: " + maxProduct(new int[] {3,-1,4}));
        System.out.println("Res: " + maxProduct(new int[] {-3,-1,-1}));
    }

    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int runProd = 1;

        for (int n : nums) {
            runProd *= n;
            if (runProd > maxProd)
                maxProd = runProd;
            else if (n <= 0)
                runProd = 1;
            else runProd = n;
        }
        return maxProd;
    }
}
