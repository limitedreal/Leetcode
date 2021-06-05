package main.LeetCode.l16;

import java.util.Arrays;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.util.Arrays.sort;

public class Solution {
    public static void main(String[] args) {
        int[] x = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(x, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        sort(nums);
        int n = nums.length,closest = nums[0]+nums[1]+nums[2];
        //想不到什么办法，就先嗯暴力试试吧
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                //在这一层中，我们想二分找到距离target与前两个值的差值最近的一个数
                //findClosed(nums,abs(target-nums[i]-nums[j]),j+1,n-1);
                for (int k = j+1;k<n;k++){
                    int temp =nums[i]+nums[j]+nums[k] ;
                    if(abs(target-temp)<abs(target-closest)){
                        closest = temp;
                    }
                }
            }
        }
        return closest;
    }

    public static int findClosed(int[] nums, int target, int low, int high) {
        //二分找到距离target最近的一个数的下标
        int middle = 0;
        while (low < high) {
            middle = (low + high) / 2;
            if (nums[middle] > target) {
                low = middle + 1;
            } else if (nums[middle] < target) {
                high = middle;
            } else {
                return middle;
            }
        }
        //下面我们想在middle的两边和本身这三个数字中取出那个可能与target差距的绝对值的一个数
        //就要考虑到很多种情况
        if (middle == 0) {
            return min(abs(nums[middle] - target)
                    , abs(nums[middle + 1] - target));
        }
        if (middle == nums.length - 1) {
            return min(abs(nums[middle] - target)
                    , abs(nums[middle - 1] - target));
        }
        return min(
                min(abs(nums[middle] - target), abs(nums[middle - 1] - target)),
                abs(nums[middle + 1] - target));
    }
}
