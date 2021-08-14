package main.beike.exam3;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] a = {0, 8, 6, 2, 4};
        section(a, 6);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型一维数组
     * @param t int整型
     * @return long长整型
     */
    public static long section(int[] a, int t) {
        //奇特区间是一个闭集，非奇特区间的种类就是要去除每个奇特集合的一个端点，就可以阻止奇特区间
        //这里暴力法应该是不可以的，是一道很难的题
        //首先所有奇特区间的组合
        int n = a.length;
        Map<Integer, Integer> map = new HashMap();
        int pre;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((a[i] ^ a[j]) == t) {
                    int min = Math.min(i, j);
                    int max = Math.max(i, j);
                    map.put(min, max);
                    break;
                }
            }
        }
        long result = 0;
        //此处统计逻辑有误
        Set<Integer> keys = map.keySet();
        //List<Integer> collect = keys.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            //这里两个限制逻辑，取最小的
            // 首先是本身对应的最小奇特区间
            //另外是left在他之后的奇特区间中right最小的
            int max = map.getOrDefault(i, n);
            for (Integer j : keys) {
                if (j > i) {
                    max = Math.min(max, map.get(j));
                }
            }
            int k=(max - i - 1);
            if(k>0){
                result += k;
            }
            //for (int j = i + 1; j < max; j++) {
            //    result++;
            //}
        }
        return result;
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
