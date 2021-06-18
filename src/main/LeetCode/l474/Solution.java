package main.LeetCode.l474;


public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"10", "0", "1"};
        System.out.println(s.findMaxForm(strs, 1, 1));
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] weight = new int[strs.length+1][2];
        for (int i = 1; i < strs.length+1; i++) {
            for (int j = 0; j < strs[i-1].length(); j++) {
                if (strs[i-1].charAt(j) == '0') {
                    weight[i][0]++;
                } else {
                    weight[i][1]++;
                }
            }
        }
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i < strs.length + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (i == 0 || (j == 0 && k == 0)) {
                        dp[i][j][k] = 0;
                        continue;
                    }
                    if (weight[i][0] > j || weight[i][1] > k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                dp[i - 1][j - weight[i][0]][k - weight[i][1]] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];

    }
}
