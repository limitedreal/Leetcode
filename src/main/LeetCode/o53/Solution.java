package main.LeetCode.o53;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] x = {5, 7, 7, 8, 8, 10};
        System.out.println(s.search(x, 8));
    }

    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return 0;
        }
        int low = index;
        int high = index+1;
        int cnt=0;
        while (true) {
            boolean flag1 = false, flag2 = false;
            if (low >= 0 && nums[low] == target) {
                low--;
                flag1 = true;
                cnt++;
            }
            if (high < nums.length && nums[high] == target) {
                high++;
                flag2 = true;
                cnt++;
            }
            if ((!flag1) && (!flag2)) {
                break;
            }
        }
        return cnt;
    }

}
