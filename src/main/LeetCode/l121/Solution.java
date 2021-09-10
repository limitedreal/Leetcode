package main.LeetCode.l121;

public class Solution {

    public int maxProfit(int[] prices) {
        //动态规划，在原数组上面记录在此之前最小的价格
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int t = prices[i] - prices[i - 1];
            profit=Math.max(profit,t);
            prices[i]=Math.min(prices[i],prices[i-1]);
        }
        return profit;
    }
}
