package main.meituan.qiuzhao.exam5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static int[] arr;
    static int[] sorted;
    static int result = 0;
    static int[] pre;
    static int[] last;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        pre = new int[n];
        last = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sorted = Arrays.copyOf(arr, arr.length);
        //两个前后缀
        //在此之前的最大值
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], arr[i]);
        }
        //在此之后的最小值
        last[arr.length - 1] = arr[arr.length - 1];
        for (int i = n - 2; i >= 0; i--) {
            last[i] = Math.min(last[i + 1], arr[i]);
        }
        Arrays.sort(sorted);
        digui(0, 0);
        System.out.println(result);
    }

    public static void digui(int low, int cnt) {
        if (result != 0) {
            return;
        }
        if (low >= arr.length) {
            result = cnt;
            return;
        }
        if(sorted[low]<last[low]){
            return;
        }
        for (int high = low; high < arr.length; high++) {
            //我们的目标是arr[low]和arr[high]覆盖前后缀
            if(sorted[high]>=pre[high]){
                digui(high+1,cnt+1);
            }
        }
    }
}
