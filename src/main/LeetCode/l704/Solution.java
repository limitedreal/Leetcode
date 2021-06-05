package main.LeetCode.l704;

public class Solution {
    public static void main(String[] args) {
        search(new int[]{-1,0,3,5,9,12},9);
    }
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length-1,middle = low + (high - low) / 2;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if(nums[middle]==target){
                return middle;
            }else if(nums[middle]<target){
                low = middle+1;
            }else{
                high = middle-1;
            }
        }
        return -1;
    }
}
