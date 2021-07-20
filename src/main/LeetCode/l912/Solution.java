package main.LeetCode.l912;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Solution {

    public static void main(String[] args) {
        int[] x = {3, -1};
        Solution s = new Solution();
        s.sortArray(x);
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end - start < 1) {
            return;
        }
        //返回最终pivot的index
        int low = start;
        int high = end;
        int pivot = nums[low];
        while (low < high) {
            while (low < high) {
                if (nums[high] <= pivot) {
                    nums[low] = nums[high];
                    break;
                }
                high--;
            }
            while (low < high) {
                if (nums[low] > pivot) {
                    nums[high] = nums[low];
                    break;
                }
                low++;
            }
        }
//        AbstractQueuedSynchronizer
        nums[low] = pivot;
        quickSort(nums, start, low - 1);
        quickSort(nums, low + 1, end);
    }
}
