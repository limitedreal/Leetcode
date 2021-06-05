package main.LeetCode.l7;

import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-321));
        System.out.println(reverse(0));
        System.out.println(reverse(2147483647));
    }

    public static int reverse(int x) {
        //Integer.MAX_VALUE;Integer.MIN_VALUE;
        char[] target = Integer.valueOf(x).toString().toCharArray();
        int n = target.length;
        char[] result = new char[n];
        int index = 0;
        if(target[0]=='-'){
            result[0] = target[0];
            index++;
        }
        for (int i = n - 1; i >= 0; i--,index++) {
            if (target[i] == '-') {
                break;
            }
            result[index] = target[i];
        }
        BigDecimal bigDecimal = new BigDecimal(result);
        if (bigDecimal.compareTo(new BigDecimal(Integer.MAX_VALUE)) != 1//不比最大值打
                && bigDecimal.compareTo(new BigDecimal(Integer.MIN_VALUE)) != -1) {
            //不比最小值小
            return bigDecimal.intValue();
        }
        return 0;
    }
}
