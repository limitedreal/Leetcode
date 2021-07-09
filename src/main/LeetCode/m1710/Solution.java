package main.LeetCode.m1710;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] x = {3,2,3};
        System.out.println(s.majorityElement(x));
    }

    public int majorityElement(int[] nums) {
        int x = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                x = nums[i];
                cnt = 1;
            } else {
                cnt += nums[i] == x ? 1 : -1;
            }
        }
        cnt = 0;
        for (int num : nums) {
            cnt += num == x ? 1 : 0;
        }
        return cnt > nums.length / 2 ? x : -1;
    }
}
