package main.meituan.qiuzhao.exam2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m=sc.nextInt();
        int q=sc.nextInt();
        boolean[][] adjacent=new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int u=sc.nextInt()-1;
            int v=sc.nextInt()-1;
            adjacent[u][v]=true;
            adjacent[v][u]=true;
        }
        //地铁编号映射
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < q; i++) {
            int x=sc.nextInt()-1;
            int y=sc.nextInt()-1;
            Integer ix = map.getOrDefault(x, x);
            Integer iy = map.getOrDefault(y, y);
            map.put(x,iy);
            map.put(y,ix);
        }
        for (int i = 0; i < n; i++) {
            int count=0;
            int x=map.getOrDefault(i,i);
            for (int y = 0; y < n; y++) {
                if(adjacent[x][y]){
                    count++;
                }
            }
            System.out.print(count+" ");
        }
    }
}
