package com.dipendit;

public class ContainerWater {

    public static void main(String[] args) {
        System.out.println("Max water: " + mostWater(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println("Max water: " + mostWater(new int[] {1, 1}));
    }

    public static int mostWater(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        else if (n == 1) return 0;

        int mp = 1;
        int hhi = 0;
        int dt = 0;
        for (int i = 1; i < n; i++) {
            dt = i - hhi;
            int tp = dt * height[i];
            if (tp > mp) mp = tp;

            if (height[i] > height[hhi]) hhi = i;
        }
        return mp;
    }

}
