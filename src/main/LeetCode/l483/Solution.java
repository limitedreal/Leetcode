package main.LeetCode.l483;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.smallestGoodBase("16035713712910627"));
    }

    public String smallestGoodBase(String n) {
        long nValue = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nValue) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nValue, 1.0 / m);
            //long sn= ((1-(long)Math.pow(k,m+1))/(1-k));

            long sn= 1;
            long mul=1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sn += mul;
            }
            if(sn==nValue){
                return Integer.toString(k);
            }
        }
        return Long.toString(nValue - 1);
    }
}
