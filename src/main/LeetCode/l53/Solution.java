package main.LeetCode.l53;

import java.util.Map;

public class Solution {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
