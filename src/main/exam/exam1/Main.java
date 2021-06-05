package main.exam.exam1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int[][] a = new int[n][m];
        int i,j;
        for ( i = 0;i<n;i++){
            for ( j = 0;j<m;j++){
                a[i][j] = sc.nextInt();
            }
        }
        for ( j = 0;j<m;j++){
            for ( i = 0;i<n-1;i++){
                System.out.print(a[i][j]+" ");
            }
            System.out.print(a[i][j]);
            System.out.println();
        }

    }
}
