package main.LeetCode.l28;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("hello", "ll"));
        "hello".indexOf("s");
    }
    public int strStr(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }
        if("".equals(haystack)){
            return -1;
        }
        return MyKMP(haystack,needle);
    }
    public int MyKMP(String s,String t){
        int[] next = new int[t.length()];
        int i=0,j=0;
        myGetNext(t,next);
        while (i<s.length()&&j<t.length()){
            if(j==-1||s.charAt(i)==t.charAt(j)){
                i++;j++;

            }else{
                j=next[j];
            }
        }
        if(j>=t.length()){
            return i-t.length();
        }else{
            return -1;
        }
    }
    private void myGetNext(String t,int[] next){
        int j=0,k=-1;
        next[0]=-1;
        while (j<t.length()-1){
            if(k==-1||t.charAt(j)==t.charAt(k)){
                j++;k++;
                next[j]=k;
            }else{
                k=next[k];
            }
        }
    }

}
