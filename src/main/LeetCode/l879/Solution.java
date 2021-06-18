package main.LeetCode.l879;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] group = {2, 3, 5}, profit = {6, 7, 8};
        System.out.println(s.profitableSchemes(10, 5, group, profit));
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int sumProfit=0;
        for (int i=0;i<profit.length;i++){
            sumProfit+=profit[i];
        }
        int[][] dp = new int[sumProfit + 1][n + 1];
        for (int k = 0; k < group[k]; k++) {
            for (int i =sumProfit;i>=0;i--){
                for (int j=n;j>=0;j--){
                    if(j>=group[k]){
                        //dp[i][j]= dp[]
                    }

                }
            }
        }
    return 0;
    }
}
