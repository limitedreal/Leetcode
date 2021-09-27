package main.LeetCode.l64;

public class Solution {
public static int result=0;
    public int sumNums(int n) {
        boolean b = n > 1 && sumNums(n - 1) > 0;
        result+=n;
        return result;
    }
}
