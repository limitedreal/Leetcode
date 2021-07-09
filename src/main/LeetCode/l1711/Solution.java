package main.LeetCode.l1711;

import java.util.*;

public class Solution {
    public long fastPow(long base, long exponent, long mod) {
        long result = 1;
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                result = base * result % mod;
            }
            exponent = exponent >> 1;
            base = base * base % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        Integer x = 5;
        Solution s = new Solution();
        System.out.println(s.fastPow(9, 1000000000, 7));
        System.out.println(s.fastPower(9, 1000000000, 7));
        System.out.println(Math.pow(2, 1000));
    }

    long fastPower(long base, long power, long mod) {
        long result = 1;
        while (power > 0) {
            if ((power & 1) == 1) {//此处等价于if(power%2==1)
                result = result * base % mod;
            }
            power >>= 1;//此处等价于power=power/2
            base = (base * base) % mod;
        }
        return result;
    }

    public int countPairs(int[] deliciousness) {
        //首先找到最大的两个数的和
        int first = 0;
        if (deliciousness.length < 2) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
            if (deliciousness[i] > deliciousness[first]) {
                first = i;
            }
        }
        int t = deliciousness[first]*2;
        int max = 0;
        while (t != 0) {
            t = t >> 1;
            max++;
        }
        max++;
        int[] bin = new int[max];
        bin[0] = 1;
        for (int i = 1; i < max; i++) {
            bin[i] = bin[i - 1] << 1;
        }
        int result = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = 0; j < max; j++) {
                int temp = bin[j] - deliciousness[i];
                if(temp<0){
                    continue;
                }
                Integer r = map.getOrDefault(temp, 0);
                if (deliciousness[i] == temp) {
                    r--;
                }
                result += r;
                result %= 1000000007;
            }
        }
        long x = (result * (long) 500000004) % 1000000007;
        return (int) x;

    }
}
