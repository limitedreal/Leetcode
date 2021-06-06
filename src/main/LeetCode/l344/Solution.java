package main.LeetCode.l344;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[] arr = {'h','e','l','l','o'};
        s.reverseString(arr);
        System.out.println(arr);
    }
    public void reverseString(char[] s) {
        //双指针法
        int low=0,high=s.length-1;
        while (low<high){
            char t = s[low];
            s[low]=s[high];
            s[high]=t;
            low++;high--;
        }
    }
}
