package main.LeetCode.l926;

public class Solution {
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        //此前1的个数
        int[]pre=new int[n];
        //此后0的个数
        int[]end=new int[n];
        if(s.charAt(0)=='1'){
            pre[0]=1;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                pre[i]=pre[i-1]+1;
            }else{
                pre[i]=pre[i-1];
            }
        }
        if(s.charAt(n-1)=='0'){
            end[n-1]=1;
        }
        for (int i = n-2; i >=0; i--) {
            if(s.charAt(i)=='0'){
                end[i]=end[i+1]+1;
            }else{
                end[i]=end[i+1];
            }
        }
        int result=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result=Math.min(result,pre[i]+end[i]);
        }
        return result-1;
    }
}
