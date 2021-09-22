package main.shopee.exam1;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        //String[]commands={"help","version","status"};
        //String input="statsu";
        String[] commands = {"version", "view"};
        String input = "ver";

        String s1 = s.didYouMean(commands, input);
        System.out.println(s1);
    }

    public String didYouMean(String[] commands, String input) {
        //对每个commands检测一次最少匹配次数
        String result = null;
        int min = Integer.MAX_VALUE;
        for (String command : commands) {
            int cnt = getDistance(input, command);
            if (cnt < min) {
                result = command;
                min = cnt;
            }
        }
        return result;
    }

    public int getDistance(String str, String target) {
        int m = str.length(), n = target.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int t = Math.min(dp[i - 1][j - 1] + 1, dp[i][j - 1] + 1);
                    t = Math.min(t, dp[i - 1][j] + 1);
                    dp[i][j] = t;
                }
            }
        }
        return dp[m][n];
    }
}
