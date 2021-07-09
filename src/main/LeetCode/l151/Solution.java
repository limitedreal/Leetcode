package main.LeetCode.l151;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("the sky is blue"));
    }
//    public String reverseWords(String s) {
//        StringBuilder result = new StringBuilder();
//        for (int i = 0;i<s.length();i++){
//            if(s.charAt(i)!=' '){
//                int j = i;
//                while (s.charAt(j)!=' '){
//                    j++;
//                    if(j==s.length()){
//                        break;
//                    }
//                }
//                result.insert(0,s.substring(i,j)+" ");
//                i=j;
//            }
//        }
//        if(result.charAt(result.length()-1)==' '){
//            result.deleteCharAt(result.length()-1);
//        }
//        return result.toString();
//    }

    public String reverseWords(String s) {
        //现在我们用更好地方法实现一次，方法是先翻转整个字符串然后在对每个单词翻转
        char[] str = s.toCharArray();
        reverse(str, 0, str.length - 1);
        StringBuilder result = new StringBuilder();;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                int start = i;
                while (i < str.length && str[i] != ' ') {
                    i++;
                }
                i--;
                if(result.length()!=0){
                    result.append(" ");
                    result.append(reverse(str, start, i));
                }else{
                    result.append(reverse(str, start, i));
                }

            }
        }
        return result.toString();
    }

    public String reverse(char[] s, int start, int end) {
        //双指针法
        int low = start, high = end;
        while (low < high) {
            char t = s[low];
            s[low] = s[high];
            s[high] = t;
            low++;
            high--;
        }
        return new String(s, start, end - start + 1);
    }
}
