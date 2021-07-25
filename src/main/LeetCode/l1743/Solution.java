package main.LeetCode.l1743;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

    public static void main(String[] args) {
        int[][] x = {{1, -1}};
        Solution s = new Solution();
        s.restoreArray(x);
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        //我们现在使用一种方法，只寻找只用了一次的，然后从他开始找
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            int i = adjacentPair[0], j = adjacentPair[1];
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
            countMap.put(j, countMap.getOrDefault(j, 0) + 1);
            List<Integer> listi = map.getOrDefault(i, new ArrayList<>(adjacentPair.length));
            listi.add(j);
            map.put(i, listi);
            List<Integer> listj = map.getOrDefault(j, new ArrayList<>(adjacentPair.length));
            listj.add(i);
            map.put(j, listj);
        }
        int start = 0;
        for (Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                start = entry.getKey();
                break;
            }
        }
        int[] result = new int[adjacentPairs.length + 1];
        List<Integer> list = map.get(start);
        result[0] = start;
        result[1] = list.get(0);
        start = list.get(0);
        for (int i = 2; i < result.length; i++) {
            list = map.get(start);
            for (Integer j : list) {
                if (j != result[i - 2]) {
                    start = j;
                }
            }
            result[i] = start;
        }
        return result;

    }
}
