package main.exam.tencent.exam2;

import java.util.Scanner;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] tran = new int[t];
        for (int i = 0; i < t; i++) {
            tran[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < tran.length; i++) {
            int count = findCount(tran[i], 0);
            System.out.println(count);
        }
    }

    public static int findCount(int n, int count) {
        if (n == 0) {
            return count;
        }
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        //我们可以进行一下小小的剪枝
        //首先对于2的倍数，如果他除完2是2或者三的倍数，那她就不应该选择-1
        //因为/2或者/3总是比-1更好的。
        boolean flag = true;
        if (n % 2 == 0) {
            int t = n / 2;
            first = findCount(t, count + 1);
            if (t % 2 == 0 || t % 3 == 0) {
                flag = false;
            }
        } else if (n % 3 == 0) {
            int t = n / 3;
            first = findCount(t, count + 1);
            if (t % 2 == 0 || t % 3 == 0) {
                flag = false;
            }
        }
        if((n-1)%2==0||((n-1)%3==0)){
            flag = true;
        }
        if((n-2)%2==0||((n-2)%3==0)){
            flag = true;
        }
        if (flag) {
            second = findCount(n - 1, count + 1);
        }
        return min(first, second);
    }

}