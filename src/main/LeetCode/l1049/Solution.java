package main.LeetCode.l1049;

public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int t = sum * 2 + 1;
        int[][] dp = new int[n][t];
        dp[0][sum + stones[0]] += 1;
        dp[0][sum - stones[0]] += 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < t; j++) {
                dp[i][j] = dp[i - 1][Math.max(0, j - stones[i])] + dp[i - 1][Math.min(t - 1, j + stones[i])];
            }
        }
        for (int j = sum; j < t; j++) {
            if (dp[n - 1][j] != 0) {
                return j-sum;
            }
        }
        return sum;
    }
}
