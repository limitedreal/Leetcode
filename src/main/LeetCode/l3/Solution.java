package main.LeetCode.l3;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.lengthOfLongestSubstring(" "));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int max=0;
        int pre=-1;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            int temp = map.getOrDefault(c, -1);
            pre=Math.max(pre,temp);
            max=Math.max(max,i-pre);
            map.put(c,i);
        }
        return max;
    }
}
