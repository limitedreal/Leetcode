package main.jd.qiuzhao.exam1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int[] xLocation = new int[n];
        int[] yLocation = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            xLocation[i] = x;
            yLocation[i] = y;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = xLocation[i];
                int y1 = yLocation[i];
                int x2 = xLocation[j];
                int y2 = yLocation[j];
                if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
