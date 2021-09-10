package main.zoom.exam2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;
        int step = 1;
        s.slideWindow(nums, windowSize, step);
    }

    public int[] slideWindow(int[] pre, int windowSize, int step) {
        int[] nums = Arrays.copyOf(pre, pre.length + windowSize - 1);
        for (int i = pre.length; i < pre.length + windowSize - 1; i++) {
            nums[i] = Integer.MIN_VALUE;
        }
        int n = nums.length;
        List<Integer> maxList = new ArrayList<>();
        Deque<Integer> maxIndex = new LinkedList<>();
        int k = windowSize;
        for (int i = 0; i < windowSize; i++) {
            while (true) {
                if (!maxIndex.isEmpty()
                        && nums[i] > nums[maxIndex.peekLast()]) {

                } else {
                    break;
                }
                maxIndex.pollLast();
            }
            maxIndex.offerLast(i);
        }
        for (int i = k; i < nums.length; i++) {
            maxList.add(nums[maxIndex.peekFirst()]);
            while (!maxIndex.isEmpty() && nums[i] > nums[maxIndex.peekLast()]) {
                maxIndex.pollLast();
            }
            while (!maxIndex.isEmpty() && maxIndex.peekFirst() <= (i - k)) {
                maxIndex.pollFirst();
            }
            maxIndex.offerLast(i);
        }
        maxList.add(nums[maxIndex.peekFirst()]);
        List<Integer> result1=new LinkedList<>();
        int[] result = new int[maxList.size()];
        int j=0;
        for (int i = 0; i < result.length; i++) {
            if(j<step){
                j++;
            }else{
                j=0;
                result1.add(maxList.get(i));
            }
        }
        return result;
    }
}
