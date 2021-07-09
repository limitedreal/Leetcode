package main.LeetCode.l930;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //public int numSubarraysWithSum(int[] nums, int goal) {
    //    //或许前n项和可以对时间复杂度降一次
    //    int result = 0;
    //    for (int i = 0; i < nums.length; i++) {
    //        int sum = 0;
    //        for (int j = i; j >= 0; j--) {
    //            sum += nums[j];
    //            if (sum == goal) {
    //                result++;
    //            }
    //        }
    //    }
    //    return result;
    //}
    //public int numSubarraysWithSum(int[] nums, int goal) {
    //    //这道题有一个特点是数组为二元数组，所以我们可以用hash表来实现
    //    Map<Integer, Integer> map = new HashMap<>();
    //    int[] sum = new int[nums.length];
    //    int t = 0;
    //    for (int i = 0; i < nums.length; i++) {
    //        t += nums[i];
    //        sum[i] = t;
    //    }
    //    map.put(0, 1);
    //    int result = 0;
    //    for (int i = 0; i < nums.length; i++) {
    //        int r = sum[i], l = r - goal;
    //        result += map.getOrDefault(l, 0);
    //        map.put(r, map.getOrDefault(r, 0) + 1);
    //    }
    //    return result;
    //
    //}
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] x = {1};
        System.out.println(s.numSubarraysWithSum(x, 1));
    }


    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] sum = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            t += nums[i];
            sum[i] = t;
        }
        int result = 0;
        map.put(0, 1);
        for (int j : sum) {
            t = j;
            int l = t - goal;
            result += map.getOrDefault(l, 0);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return result;
    }
}
