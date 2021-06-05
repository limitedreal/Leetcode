package main.LeetCode.l54;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //int [][] x = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int [][] x = {{1},{2},{3}};
        spiralOrder(x);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new LinkedList<>();
        int n1 = matrix.length, n2 = matrix[0].length;
        //走的顺序是右下左上
        boolean[][] reached = new boolean[n1][n2];
        int i = 0,j = 0;
        boolean flag = true;//flag为false的时候就可以停止了
        while (flag){
            //右下左上
            while (j<n2&& !reached[i][j]){
                resultList.add(matrix[i][j]);
                reached[i][j] = true;
                j++;
            }
            j--;
            i++;
            while (i<n1&&!reached[i][j]){
                resultList.add(matrix[i][j]);
                reached[i][j] = true;
                i++;
            }
            i--;
            j--;
            while (j>=0&&!reached[i][j]){
                resultList.add(matrix[i][j]);
                reached[i][j] = true;
                j--;
            }
            j++;
            i--;
            while (i>=0&&!reached[i][j]){
                resultList.add(matrix[i][j]);
                reached[i][j] = true;
                i--;
            }
            i++;
            j++;
            if(resultList.size()==n1*n2){
                flag=false;
            }
        }
        return resultList;
    }

    //public static boolean go(int[] now,int direction){
    //    //direction 0 1 2 3 右下左上
    //
    //
    //}



}
