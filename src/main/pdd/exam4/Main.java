package main.pdd.exam4;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //BigDecimal result1 = new BigDecimal(0);
        //BigDecimal result2 = new BigDecimal(1);
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong(), M = sc.nextLong();
        BigDecimal n = new BigDecimal(N);
        BigDecimal m = new BigDecimal(M);
        BigDecimal result = jiecheng(N);
        long k = postZero(result, m);
        System.out.println(k);
    }

    public static BigDecimal jiecheng(long n) {
        BigDecimal result = new BigDecimal(1);
        for (long i = 1; i <= n; i++) {
            result = result.multiply(new BigDecimal(i));
        }
        return result;
    }

    public static long postZero(BigDecimal target, BigDecimal m) {
        BigDecimal zero = new BigDecimal(0);
        long count = 0;
        while (target.compareTo(zero) > 0) {
            BigDecimal[] temp = target.divideAndRemainder(m);
            if (temp[1].compareTo(zero) != 0) {
                return count;
            } else {
                count++;
                target = temp[0];
            }

        }
        return count;
    }
}
