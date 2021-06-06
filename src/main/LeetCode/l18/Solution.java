package main.LeetCode.l18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] k = {0,0,0};
        s.threeSum(k);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3){
            return null;
        }
        Arrays.sort(nums);
        int low,high;
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(i>=1&&nums[i]==nums[i-1]){
                continue;
            }
            low=i+1;
            high=nums.length-1;
            while (low<high){
                if(nums[low]+nums[high]>-nums[i]){
                    high--;
                }else if(nums[low]+nums[high]<-nums[i]){
                    low++;
                }else{
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    lists.add(list);
                    int t = low;
                    while (nums[t]==nums[low]&&low<high){
                        low++;
                    }
                    t=high;
                    while (nums[t]==nums[high]&&low<high){
                        high--;
                    }
                }
            }
        }
        return lists;
    }
    public List<List<Integer>> fourSum(int[] nums) {
        if(nums.length<4){
            return null;
        }
        Arrays.sort(nums);
        int low,high;
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(i>=1&&nums[i]==nums[i-1]){
                continue;
            }
            low=i+1;
            high=nums.length-1;
            while (low<high){
                if(nums[low]+nums[high]>-nums[i]){
                    high--;
                }else if(nums[low]+nums[high]<-nums[i]){
                    low++;
                }else{
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    lists.add(list);
                    int t = low;
                    while (nums[t]==nums[low]&&low<high){
                        low++;
                    }
                    t=high;
                    while (nums[t]==nums[high]&&low<high){
                        high--;
                    }
                }
            }
        }
        return lists;
    }
}
