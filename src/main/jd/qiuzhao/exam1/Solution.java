package main.jd.qiuzhao.exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer[]> list = new ArrayList<>();
        //int[][] location = new int[n][2];
        int[] xLocation = new int[n];
        int[] yLocation = new int[n];
        int xMax = 0;
        int yMax = 0;
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            xLocation[i] = x;
            yLocation[i] = y;
            xMax = Math.max(x, xMax);
            yMax = Math.max(y, yMax);
            xMin = Math.min(x, xMin);
            yMin = Math.min(y, yMin);
        }
        for (int i = 0; i < xLocation.length; i++) {
            xLocation[i] -= xMin;
            yLocation[i] -= yMin;
        }
        boolean[][] adjacent = new boolean[xMax - xMin + 1][yMax - yMin + 1];

        for (int i = 0; i < n; i++) {
            adjacent[xLocation[i]][yLocation[i]] = true;
        }
        int cnt = 0;
        int x;
        int y;
        for (int i = 0; i < n; i++) {
            x = xLocation[i];
            y = yLocation[i];
            cnt -= 4;
            while (x >= 0 && y >= 0 && x < adjacent.length && y < adjacent[0].length) {
                if (adjacent[x][x]) {
                    cnt++;
                }
                x++;
                y++;
            }
            x = xLocation[i];
            y = yLocation[i];
            while (x >= 0 && y >= 0 && x < adjacent.length && y < adjacent[0].length) {
                if (adjacent[x][x]) {
                    cnt++;
                }
                x--;
                y++;
            }
            x = xLocation[i];
            y = yLocation[i];
            while (x >= 0 && y >= 0 && x < adjacent.length && y < adjacent[0].length) {
                if (adjacent[x][x]) {
                    cnt++;
                }
                x++;
                y--;
            }
            x = xLocation[i];
            y = yLocation[i];
            while (x >= 0 && y >= 0 && x < adjacent.length && y < adjacent[0].length) {
                if (adjacent[x][x]) {
                    cnt++;
                }
                x--;
                y--;
            }
        }
        System.out.println(cnt/2);
    }
}
