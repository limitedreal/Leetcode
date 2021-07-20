package main.LeetCode.l1838;

import static java.lang.Math.max;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] x = {1, 4};
        Solution s = new Solution();
        System.out.println(s.maxFrequency(x, 5));
    }

    class Others {

        public int maxFrequency(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;

            int l = 0, ans = 1;
            long sum = 0;
            for (int r = 1; r < n; r++) {
                sum += (long) (nums[r] - nums[r - 1]) * (r - l);
                while (sum > k) {
                    sum -= nums[r] - nums[l];
                    l++;
                }
                ans = max(ans, r - l + 1);
            }
            return ans;

        }
    }

    public int maxFrequency(int[] nums, int k) {
        if(nums.length<=1){
            return nums.length;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;//阴影总面积
        int low = 0;//左边界
        int ans = 0;
        for (int high = 1; high < n; high++) {
            sum += (long) (nums[high] - nums[high - 1]) * (high - low);
            while (sum > k) {
                sum -= nums[high] - nums[low];
                low++;
            }
            ans = Math.max(ans, high - low + 1);
        }
        return ans;
    }
}
