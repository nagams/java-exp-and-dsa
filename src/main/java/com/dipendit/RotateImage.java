package com.dipendit;

public class RotateImage {

    public static void main(String[] args) {
        int[][] mat1 = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        //rotate(mat1);

        int[][] mat2 = {{5,1,9,11},
                        {2,4,8,10},
                        {13,3,6,7},
                        {15,14,12,16}};
        rotate(mat2);

        int[][] mat3 = {{1}};
        //rotate(mat3);
    }
    public static void rotate(int[][] matrix) {
        /*
            [[1,2,3],
             [4,5,6],
             [7,8,9]]
                ||
            [[7,4,1],  t=3
             [8,5,2],
             [9,6,3]]

         */
        int n = matrix.length;
        int left = 0, right = n-1, top = 0, bottom = n-1;
        while (left < right && top < bottom) {

            int lc_i = top;
            int br_j = right;
            int fc_i = bottom;
            for (int tr_j = left; tr_j < right; tr_j++ ) {
                // topLeft
                int temp1 = matrix[lc_i][right]; // save top right
                matrix[lc_i][right] = matrix[top][tr_j]; // topLeft -> topRight
                // topRight
                int temp2 = matrix[bottom][br_j];  // save bottom right
                matrix[bottom][br_j] = temp1;  // topRight -> botRight
                // botRight
                temp1 = matrix[fc_i][left]; // save bottom left
                matrix[fc_i][left] = temp2; // botRight -> botLeft
                // botLeft
                matrix[top][tr_j] = temp1; // botLeft -> topLeft
                lc_i++;
                br_j--;
                fc_i--;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        print2DArray(matrix);
    }

    public static void print2DArray(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" [");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.print("]");

            System.out.println();
        }
        System.out.println("]");
    }
}
