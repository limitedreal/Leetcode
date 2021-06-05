package main.LeetCode.l27;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] k=new int[0];
        System.out.println(k.length);
        System.out.println(Arrays.toString(k));
        removeElement(k,0);
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
                i--;
            }
        }
        return n;
    }

}
