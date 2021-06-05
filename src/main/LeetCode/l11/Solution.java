package main.LeetCode.l11;

import static java.lang.Math.min;

public class Solution {
    //盛水最多的容器
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int MAX = 0;
        int low = 0,high = height.length-1;
        while (low<high){
            int nowHeight;
            if(height[low]<height[high]){
                nowHeight = height[low];
                low++;
            }else{
                nowHeight = height[high];
                high--;
            }
            int nowCapacity = nowHeight*(high-low+1);
            MAX = Math.max(MAX, nowCapacity);
        }
        return MAX;
    }
}
