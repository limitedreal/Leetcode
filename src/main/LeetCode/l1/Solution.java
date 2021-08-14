package main.LeetCode.l1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] x = {2, 7, 11, 15};
        Solution s = new Solution();
        s.twoSum(x, 9);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i],list);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                for (Integer j : map.get(target - nums[i])) {
                    if (j != i) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{0, 0};
    }
}
