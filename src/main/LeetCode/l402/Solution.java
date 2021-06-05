package main.LeetCode.l402;

public class Solution {
    static {a=1;}
    static int a = 2;
    static {a=3;}
    public static void main(String[] args) {
        System.out.println(removeKdigits("10",1));
        
        System.out.println(a);
    }
    public static String removeKdigits(String num, int k) {
        int n = num.length();
        if(n<=k){
            return "0";
        }
        StringBuilder str = new StringBuilder(num);
        for (int i=0;i<k;i++){
            removeOne(str);
        }
        remove0(str);
        return str.toString();

    }
    public static void remove0(StringBuilder num){
        int n = num.length();
        for (int i = 0;i<n;i++){
            if(num.charAt(0)!='0'){
                return;
            }
            num.deleteCharAt(0);
        }
        num.append("0");
    }

    public static void removeOne(StringBuilder num){
        int n = num.length();
        for (int i = 0;i<n-1;i++){
            if(num.charAt(i)>num.charAt(i+1)){
                num.deleteCharAt(i);
                return;
            }
        }
        num.deleteCharAt(n-1);
    }

}
