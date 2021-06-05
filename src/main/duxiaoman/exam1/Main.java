package main.duxiaoman.exam1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m=sc.nextInt();
        //int[] close = new int[m];
        int[] time = new int [n];
        boolean[] close = new boolean[n];
        //代表每个灯是否关闭？
        for (int i = 0;i<m;i++){
            int k = sc.nextInt()-1;
            for (int j=k;j<n;j++){
                if(time[j]==0){
                    time[j]=i+1;
                }
            }
        }
        for (int i = 0; i < time.length; i++) {
            System.out.print(time[i]+" ");
        }
        sc.close();


    }
}
