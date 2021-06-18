package main.LeetCode.l494;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,0,0,0,0,0,0,0,1};
        System.out.println(s.findTargetSumWays(nums, 1));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
            sum += nums[i];
        }
        if(Math.abs(target)>sum){
            return 0;
        }
        int len = sum * 2 + 1;
        int[][] dp = new int[n][len];
        dp[0][sum - nums[0]] += 1;
        dp[0][sum + nums[0]] += 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = dp[i - 1][Math.max(0, j - nums[i])] + dp[i - 1][Math.min(sum * 2, j + nums[i])];
            }
        }

        return dp[n-1][sum+target];
    }
}
