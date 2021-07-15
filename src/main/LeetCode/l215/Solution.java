package main.LeetCode.l215;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] x = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(s.findKthLargest(x, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            queue.poll();
        }
        return queue.poll();

    }
}
