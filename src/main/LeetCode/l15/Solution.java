package main.LeetCode.l15;

import java.lang.annotation.Target;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i+1;
            int high = nums.length - 1;
            while (low < high) {
                int now = nums[low] + nums[high];
                int target = -nums[i];
                if (now == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    result.add(list);
                    low++;
                    high--;
                } else if (now < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }
}
