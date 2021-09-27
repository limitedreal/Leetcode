package main.LeetCode.l5;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return s;
        }
        int start = 0, end = 0, length = 1;
        for (int i = 0; i < chars.length; i++) {
            //以该元素为中心
            int low = i - 1, high = i + 1;
            boolean flag = true;
            while (low >= 0 && high < chars.length) {
                if (chars[low] != chars[high]) {
                    if ((high - 1) - (low + 1) + 1 > length) {
                        start = low + 1;
                        end = high - 1;
                        length = (high - 1) - (low + 1) + 1;
                    }
                    flag=false;
                    break;
                }
                low--;
                high++;
            }
            if(flag){
                if ((high - 1) - (low + 1) + 1 > length) {
                    start = low + 1;
                    end = high - 1;
                    length = (high - 1) - (low + 1) + 1;

                }
            }
            //以该元素的下一个空隙为中心
            low = i ;
            high = i + 1;
            flag = true;
            while (low >= 0 && high < chars.length) {
                if (chars[low] != chars[high]) {
                    if ((high - 1) - (low + 1) + 1 > length) {
                        start = low + 1;
                        end = high - 1;
                        length = (high - 1) - (low + 1) + 1;
                    }
                    flag=false;
                    break;
                }
                low--;
                high++;
            }
            if(flag){
                if ((high - 1) - (low + 1) + 1 > length) {
                    start = low + 1;
                    end = high - 1;
                    length = (high - 1) - (low + 1) + 1;

                }
            }
        }
        if (length == 1) {
            return String.valueOf(chars[0]);
        } else {
            StringBuilder sb = new StringBuilder(length);
            for (int i = start; i <= end; i++) {
                sb.append(chars[i]);
            }
            return sb.toString();
        }
    }


}
