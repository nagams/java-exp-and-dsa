package com.dipendit;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat1 = {{1,2,3},
                        {8,9,4},
                        {7,6,5}};
        List<Integer> res = spiralOrder(mat1);
        res.forEach(System.out::println);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;

        while (left < right && top < bottom) {
            // get every j in the top row
            for (int j = left; j < right; j++)
                res.add(matrix[top][j]);
            top++;
            // get every i in the right col
            for (int i = top; i < bottom; i++)
                res.add(matrix[i][right-1]);
            right--;
            if (left > right || top > bottom)
                    break;
            // get every j in the bottom row
            for (int j = right-1; j >= left; j--)
                res.add(matrix[bottom-1][j]);
            bottom--;
            // get every i in the left col
            for (int i = bottom-1; i >= top; i--)
                res.add(matrix[i][left]);
            left++;
        }

        return res;
    }

}
