package main.LeetCode.l33;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,1};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        //首先找到这个旋转的位置，然后把数组分成两部分去找
        int  n = nums.length;
        //1. 暴力
        //2. 先用类似二分的方法把pivot找出来
        int pivot = binarySearchPivot(nums);
        int result1=binarySearch(nums,target,0,pivot-1);
        if(result1!=-1){
            return result1;
        }
        int result2 = binarySearch(nums,target,pivot,n-1);
        return result2;

    }
    public static int binarySearchPivot(int[] nums){
        int low = 0,high = nums.length-1,middle;
        while (low<high){
            middle = (low+high)/2;
            if(nums[middle]>nums[high]){
                low=middle;
            }else if(nums[middle] <nums[low]){
                high=middle;
            }else{
                return middle;
            }
            if(low==high-1){
                if(nums[low]<nums[high]){
                    return low;
                }else{
                    return high;
                }
            }
        }
        return low;
    }
    public static int binarySearch(int[] nums,int target,int start,int end){
        int low = start,high = end,middle = (low+high)/2;
        if(low==high){
            if(nums[low]==target){
                return low;
            }else{
                return -1;
            }

        }
        while (low<high){
            middle = (low+high)/2;
            if(nums[middle]>target){
                high = middle-1;
            }else if(nums[middle] <target){
                low = middle+1;
            }else{
                return middle;
            }
        }
        if(nums[low]==target){
            return low;
        }
        return -1;
    }
}
