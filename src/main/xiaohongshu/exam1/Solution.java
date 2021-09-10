package main.xiaohongshu.exam1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]=sc.nextInt();
            }
        }
        sc.close();
        //貌似有点眼熟，应该是做过一道原题？
        //其实方法是一维最大子序列的扩展
        //结果行列
        //int[]ans=new int[4];
        int m=n;
        //二维转为1维
        Main.getMaxMatrixSum(m, n, matrix);
    }
}
