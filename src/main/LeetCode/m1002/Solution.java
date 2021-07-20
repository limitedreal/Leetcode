package main.LeetCode.m1002;

import static java.util.Arrays.sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        //怎么做呢？我认为有两种方案，第一种是对每个string排序，然后对整个List排序
        //然后遍历一次List，就可以得到结果了
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = reorder(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> value = new LinkedList<>();
                value.add(str);
                map.put(key, value);
            }
        }
        return new LinkedList<>(map.values());
    }

    private String reorder(String str) {
        int[] chars = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            chars[t - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i]; j++) {
                sb.append(i + 'a');
            }
        }
        return sb.toString();
    }

}
