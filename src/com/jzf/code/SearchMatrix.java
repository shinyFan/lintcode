package com.jzf.code;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix=new int[3][3];
        matrix[0][0]=1;
        matrix[0][1]=4;
        matrix[0][2]=5;
        matrix[1][0]=6;
        matrix[1][1]=7;
        matrix[1][2]=8;
        boolean matrix1 = new SearchMatrix().searchMatrix(matrix, 6);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int row = matrix.length;
        if(row<1){
            return false;
        }
        int col = matrix[0].length;
        int i=0,j=0;

        while(i<row&&j<col){
            if(target<matrix[i][j]){
                return false;
            }
            if(matrix[i][j]==target){
                return true;
            }
            if (target<matrix[i+1][j]){
                j++;
                continue;
            }
            if (target>=matrix[i+1][j]){
                i++;
                continue;
            }
        }
        return false;
    }
}
