package main.LeetCode.l274;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[]x={3,0,6,1,5};
        Solution s = new Solution();
        System.out.println(s.hIndex(x));
    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i=citations.length-1,h=0;
        while (i>=0&&citations[i]>h){
            i--;
            h++;
        }
        return h;
    }
}
