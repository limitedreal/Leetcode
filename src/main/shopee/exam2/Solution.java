package main.shopee.exam2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        Integer[] g = {1, 2, 9};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(g));
        System.out.println(s.minEffort(list));
    }

    public int minEffort(ArrayList<Integer> cases) {
        //小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(cases);
        int result = 0;
        while (queue.size() > 1) {
            int t1 = queue.poll();
            int t2 = queue.poll();
            result += t1 + t2;
            queue.add(t1 + t2);
        }
        return result;
    }
}
