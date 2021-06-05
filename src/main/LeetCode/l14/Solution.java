package main.LeetCode.l14;

import static java.lang.Integer.min;
import static java.util.Arrays.sort;

public class Solution {
    public static void main(String[] args) {
        String[] x = new String[3];
        //x[0] = "flower";
        //x[1] = "flow";
        //x[2] = "flight";
        x[0] = "dog";
        x[1] = "racecar";
        x[2] = "car";
        System.out.println(longestCommonPrefix(x));
    }

    public static String longestCommonPrefix(String[] strs) {
        sort(strs);
        String start = strs[0],end = strs[strs.length-1];
        StringBuilder result = new StringBuilder();
        int n = min(start.length(),end.length());
        for (int i = 0;i<n;i++){
            if(start.charAt(i)!=end.charAt(i)){
                return result.toString();
            }
            result.append(start.charAt(i));
        }
        return result.toString();
    }
}
