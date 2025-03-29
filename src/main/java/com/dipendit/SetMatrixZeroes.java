package com.dipendit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] mat1 = {{0,1,2,0},
                        {3,4,5,2},
                        {1,3,1,5}};
        setZeroes(mat1);

        int[][] mat2 = {{1,1,2},
                        {3,0,5},
                        {1,3,1}};
        //setZeroes(mat2);

        int[][] mat3 = {{1,2,3,4},
                        {5,0,7,8},
                        {0,10,11,12},
                        {13,14,15,0}};
        //setZeroes(mat3);
    }

    public static void setZeroes(int[][] matrix) {
        int fcr = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        fcr = 0;
                    else
                        matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        print2DArray(matrix);
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[i].length; j++)
                    matrix[i][j] = 0;
            }
        }
        print2DArray(matrix);
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++)
                    matrix[i][j] = 0;
            }
        }
        print2DArray(matrix);
        if (fcr == 0) {
            Arrays.fill(matrix[0], 0);
        }
        print2DArray(matrix);
    }


    // DIDn't work
    public static void setZeroes_dntw(int[][] matrix) {
        /*
            [[0,1,2,0],
             [3,4,5,2],
             [1,3,1,5]]

            [[0,0,0,0],
             [0,4,5,0],
             [0,3,1,0]]
         */
        print2DArray(matrix);
        List<Spot> vp = new ArrayList<>();
        int i = 0;
        int j = 0;
        int encJ = -1;
        while (i < matrix.length) {
            while (j < matrix[i].length) {
                if (matrix[i][j] == 0) {
                    // Set for all j
                    for (int sj = 0; sj < matrix[i].length; sj++) {
                        if (matrix[i][sj] == 0 && sj > j)
                            vp.add(new Spot(i, sj));
                        matrix[i][sj] = 0;
                    }
                    // Set for all i
                    for (int si = 0; si < matrix.length; si++) {
                        if (matrix[si][j] == 0 && si > i)
                            vp.add(new Spot(si, j));
                        matrix[si][j] = 0;
                    }
                    encJ = j;
                    j = matrix[i].length;
                } else
                    j++;
            }
            if (encJ != -1)
                j += 1;
            else
                j = 0;
            i++;
        }
        print2DArray(matrix);

        for (Spot x : vp) {
            Arrays.fill(matrix[x.i()], 0);
            for (int xi = 0; xi < matrix.length; xi++)
                matrix[xi][x.j()] = 0;
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

record Spot(int i, int j){}
