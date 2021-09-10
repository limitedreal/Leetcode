package main.xiaohongshu.exam1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        //貌似有点眼熟，应该是做过一道原题？
        //其实方法是一维最大子序列的扩展
        int m = n;
        int result = getMaxMatrixSum(m, n, matrix);
        System.out.println(result);
    }

    static int getMaxMatrixSum(int m, int n, int[][] matrix) {
        //二维转为1维
        int result = Integer.MIN_VALUE;
        int[] dp = new int[m];
        //初始化
        for (int j = 0; j < m; j++) {
            dp[j] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[j] = 0;
            }
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    dp[k] += matrix[j][k];
                    if (sum > 0) {
                        sum += dp[k];
                    } else {
                        //如果小于0那直接等于这个
                        sum = dp[k];
                        //这里是不是要重置c1r1?
                        //害，只需要保存maxSum就行了
                    }
                    result = Math.max(sum, result);
                }
            }
        }
        return result;
    }
}
