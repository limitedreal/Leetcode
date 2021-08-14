package main.LeetCode.o42;

public class Solution {

    public static void main(String[] args) {
        int[] x = {1,-2};
        Solution s = new Solution();
        System.out.println(s.maxSubArray(x));
    }

    //    public int maxSubArray(int[] nums) {
    //        //最大前缀和法,这是一种O(n^2)的方法
    //        if (nums.length == 1) {
    //            return nums[0];
    //        }
    //        int n = nums.length;
    //        int[] pre = new int[n];
    //        int sum = 0;
    //        int max = Integer.MIN_VALUE;
    //        for (int i = 0; i < n; i++) {
    //            pre[i] = nums[i] + sum;
    //            sum = pre[i];
    //            max = Math.max(nums[i], max);
    //        }
    //
    //        for (int i = n - 1; i > 0; i--) {
    //            for (int j = i - 1; j >= 0; j--) {
    //                int t = pre[i] - pre[j];
    //                max = Math.max(t, max);
    //                max = Math.max(pre[i], max);
    //            }
    //        }
    //        return max;
    //    }
    public int maxSubArray(int[] nums) {
        //动态规划法
        int n = nums.length;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

}
