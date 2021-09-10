package main.hulu.exam3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //想一下，应该是最小生成树算法，prime？然后再找一个点
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] g = new int[n][n];
        for (int[] ints : g) {
            Arrays.fill(ints, -1);
        }
        int[] people = new int[n];
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt();
            g[a][b] = c;
            g[b][a] = c;
            g[i][i] = 0;
        }
        int[] vertix = new int[n];
        for (int i = 0; i < vertix.length; i++) {
            vertix[i] = i;
        }
        List<Integer> list = new ArrayList<>(n + 1);
        list.add(0);
        //选择一个初始点
        vertix[0] = -2;
        //已被访问
        while (list.size() < n) {
            int minDistance = Integer.MAX_VALUE;
            int minv = -1;
            int mini = -1;
            for (int i = 0; i < list.size(); i++) {
                int v1 = list.get(i);
                for (int j = 0; j < n; j++) {
                    if (vertix[j] != -2) {
                        if(g[v1][j]!=-1&&g[v1][j]<minDistance){
                            minDistance=g[v1][j];
                            minv=j;
                            mini=v1;
                        }
                    }
                }
            }
            vertix[minv]=-2;
            list.add(minv);
            result[mini][minv]=0;
            result[minv][mini]=0;
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                //result[i][j];
            }
        }
    }
}
