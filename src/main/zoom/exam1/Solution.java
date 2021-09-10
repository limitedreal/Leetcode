package main.zoom.exam1;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int find132Pattern (int[] nums) {
        //没啥好想法，暴力吧
        int n=nums.length;
        if(n<3){
            return 0;
        }
        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if(nums[i]<nums[k]&&nums[k]<nums[j]){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}