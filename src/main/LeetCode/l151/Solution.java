package main.LeetCode.l151;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("the sky is blue"));
    }
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                int j = i;
                while (s.charAt(j)!=' '){
                    j++;
                    if(j==s.length()){
                        break;
                    }
                }
                result.insert(0,s.substring(i,j)+" ");
                i=j;
            }
        }
        if(result.charAt(result.length()-1)==' '){
            result.deleteCharAt(result.length()-1);
        }
        return result.toString();
    }
}
