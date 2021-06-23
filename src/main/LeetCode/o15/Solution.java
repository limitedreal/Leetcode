package main.LeetCode.o15;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

    }
    public int hammingWeight(int n) {
        int result=0;
        for (int i=0;i<32&&n!=0;i++){
            result+=n&1;
            n=n>>1;
        }
        return result;
    }
}
