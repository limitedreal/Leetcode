package main.alibaba.qiuzhao.exam2_1;

import java.util.Scanner;

public class Main {
    static long result = 0;
    static long pow = (long) Math.pow(2, 61) - 1;
static int k=0;
    public static void main(String[] args) {
        //首先找到每一段长度单增序列，然后计算其中可能的组合数量
        Scanner sc = new Scanner(System.in);
        long pow = (long) Math.pow(2, 61) - 1;
        int n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(arr, -1, 0, 0);
        System.out.println(result % pow);

    }

    public static void dfs(int[] arr, int pre, int length, int index) {
        if(length>k){
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[index] > pre) {
                dfs(arr, arr[index], length + 1, i + 1);
                //c length k
                long temp=1;
                for(int j=length;j>length-k&&j>=1;j--){
                    temp=temp*j;
                }
                for(int j=k;j>0;j--){
                    temp/=j;
                }
                result=(result+temp)%pow;
            }
            dfs(arr,pre,length,i+1);
        }
    }
}
