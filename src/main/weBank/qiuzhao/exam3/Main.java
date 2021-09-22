package main.weBank.qiuzhao.exam3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = sc.nextInt();
        }
        int[] result=new int[n];
        result[0]=pre[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                //奇数位置
                //pre[i]=pre[i-1]+result[i];
                result[i]=pre[i]-pre[i-1];
            } else {
                result[i]=pre[i-1]-pre[i];
            }
        }
        for (int i : result) {
            System.out.println(i+" ");
        }


    }
}
