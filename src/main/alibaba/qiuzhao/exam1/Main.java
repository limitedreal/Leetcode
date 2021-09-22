package main.alibaba.qiuzhao.exam1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int o = 0; o < t; o++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long cnt = 0;
            for (int i = k + 1; i <= n; i++) {
                cnt += (n - k) / i+1;
            }
            System.out.println(cnt);
        }
    }
}
