package main.LeetCode.l523;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {23,2,4,6,6};

        int k = 7;
        System.out.println(s.checkSubarraySum(nums, k));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        //我们先算一个前缀和，然后把前缀和和k的余数hash起来
        Map<Integer,Integer> map = new HashMap();
        int remainder = 0;
        for (int i = 0; i < nums.length; i++) {
            remainder = (remainder + nums[i]) % k;
            if(remainder==0&&i>=1){
                return true;
            }
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
