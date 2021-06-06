package main.LeetCode.l541;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl"
                ,39));
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < arr.length && n >= 0) {
            if (n >= k) {
                reverseString(arr, i, i + k - 1);
            } else {
                reverseString(arr, i, arr.length - 1);
                return String.valueOf(arr);
            }
            i += 2 * k;
            n -= 2 * k;

        }
        return String.valueOf(arr);
    }

    public void reverseString(char[] s, int start, int end) {
        //双指针法
        int low = start, high = end;
        while (low < high) {
            char t = s[low];
            s[low] = s[high];
            s[high] = t;
            low++;
            high--;
        }
    }
}