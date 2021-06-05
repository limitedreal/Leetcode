package main.NewCoder.nS4_1_1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n=998244353;
        System.out.println(n);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求最小差值
     *
     * @param a int整型一维数组 数组a
     * @return int整型
     */
    public int minDifference(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int temp = a[i + 1] - a[i];
            if (temp < result) {
                result = temp;
            }
        }
        return result;
    }
}