

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //首先找到每一段长度单增序列，然后计算其中可能的组合数量
        Scanner sc = new Scanner(System.in);
        long pow = (long)Math.pow(2, 61)-1;
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int start = -1;
        int end = -1;
        long result = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                if (start == -1) {
                    start = i - 1;
                }
                end = i;
            } else {
                if (start != -1 && end != -1) {
                    //计算组合数量
                    int len = end - start + 1;
                    for (int j = k; j >1; j--) {
                        result = result % pow;
                        result += len - j;
                    }
                }
                start = -1;
            }
        }
        if (start == -1) {
            start = 0;
        }
        if (end == -1) {
            end = n - 1;
        }
        int len = end - start + 1;
        for (int j = k; j >1; j--) {
            result = result % pow;
            result += len - j;
        }
        result = result % pow;
        result += n;
        //System.out.println(n % pow);
        System.out.println(result % pow);
    }
}
