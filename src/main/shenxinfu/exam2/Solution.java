package main.shenxinfu.exam2;

public class Solution {
    public int minDistance(String a, String b) {
        //貌似是之前在LeetCode上做过的题，怎么感觉像是完全的原题。。
        //运气有点儿好
        if (a.length() == 0 || b.length() == 0) {
            return Math.max(a.length(), b.length());
        }
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[][] dp = new int[n1][n2];
        boolean flag = false;
        //初始化，整道题的思路是先找公共子序列，初始化的时候如果是可以从某一个字符开始构成
        //子序列，那么当然最好，所以第一行第一列要这么初始化。
        for (int i = 0; i < n1; i++) {
            if (arr1[i] == arr2[0] || flag) {
                dp[i][0] = i;
                flag = true;
            } else {
                dp[i][0] = i + 1;
            }
        }
        flag = false;
        for (int i = 0; i < n2; i++) {
            if (arr2[i] == arr1[0] || flag) {
                dp[0][i] = i;
                flag = true;
            } else {
                dp[0][i] = i + 1;
            }
        }
        //动态规划地寻找，因为要变换显然做一一对应是很好的。
        //从1开始，0找过了
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (arr1[i] == arr2[j]) {
                    //如果是相对等的，自然不需要变换。
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //如果不是相对等的，那么这个字符肯定要变化，那么从哪条路变化而来则需要取最小值，一开始有一个写成了max自然是有问题的。
                    //是一次更改，还是一次插入，还是一次删除，这里表现其三种行为。
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                }
            }
        }
        //最终的路径可以从最后一个按照普通的背包问题那样找，可以找到其变换方法
        //变换次数则是最后一个值。
        return dp[n1 - 1][n2 - 1];
    }
}
