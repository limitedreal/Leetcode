package main.wangyi.qiuzhao.exam3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        int n = list.size();
        int[] paper = new int[n];
        //1. 年龄>i-1 paper[i]=paper[i-1]+1;
        //正着一次反着一次即可
        for (int i = 1; i < n; i++) {
            if (list.get(i) > list.get(i - 1)) {
                paper[i] = paper[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (list.get(i) > list.get(i + 1)) {
                if (paper[i] <= paper[i + 1]) {
                    paper[i] = paper[i + 1] + 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += paper[i];
        }
        System.out.println(sum + n);
    }
}
