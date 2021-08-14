package main.beike.exam2;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        NS_String("caabeefa", 5);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @param k int整型
     * @return string字符串
     */
    public static String NS_String(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            List<Integer> list = map.getOrDefault(c, new LinkedList<>());
            list.add(i);
            map.put(c, list);
        }
        List<Character> keys = map.keySet().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            Character c = keys.get(i);
            List<Integer> list = map.get(c);
            n -= list.size();
            for (Integer j : list) {
                chars[j] = ' ';
            }
        }
        StringBuilder sb = new StringBuilder(n);
        for (char c : chars) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
