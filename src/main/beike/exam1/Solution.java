package main.beike.exam1;

public class Solution {
    public static void main(String[] args) {
        long[] result = FarmerNN(4, 11);
        int n=0;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型
     * @param m long长整型
     * @return long长整型一维数组
     */
    public static long[] FarmerNN(int n, long m) {
        //1+(n-1)+(n-1)
        long[] result = new long[n];
        if (m <= 0) {
            return result;
        }
        if (n == 1) {
            result[0] = m;
            return result;
        }
        long lun = m / (2L * (n - 1));
        long remain = m % (2L * (n - 1));
        //首先轮数可以直接赋值
        result[0] += lun;
        result[n - 1] += lun;
        for (int i = 1; i < n - 1; i++) {
            result[i] = 2 * lun;
        }
        int i = 0;
        boolean increase = true;
        while (remain > 0) {
            if (i == n) {
                i = n - 2;
                increase = !increase;
            } else if (i == -1) {
                i = 1;
                increase = !increase;
            }
            result[i]++;
            if (increase) {
                i++;
            } else {
                i--;
            }
            remain--;
        }
        return result;
    }
}
