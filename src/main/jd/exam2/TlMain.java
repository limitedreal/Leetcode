package main.jd.exam2;

import java.util.Scanner;

public class TlMain {
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] flagMatrix = new int[n][m];
        //现在我们循环查找
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (flagMatrix[i][j] == 0) {
                    dfs(matrix, flagMatrix, i, j, matrix[i][j]);
                    flagMatrix[i][j] = 0;
                }
            }
        }
        int keng = 0;
        //下面我们的任务是找到和统计成片的水坑
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                if (flagMatrix[i][j] == 1) {
                    keng++;
                    dfs2(flagMatrix, i, j);
                }
            }
        }
        System.out.println(keng);
    }

    public static void dfs(int[][] matrix, int[][] flagMatrix, int row, int column, int h) {
        if (flagMatrix[row][column] == 1) return;
        if (matrix[row][column] <= h) flagMatrix[row][column] = 1;
        if (row - 1 >= 0 && matrix[row - 1][column] <= h) dfs(matrix, flagMatrix, row - 1, column, h);
        if (row + 1 < n && matrix[row + 1][column] <= h) dfs(matrix, flagMatrix, row + 1, column, h);
        if (column - 1 >= 0 && matrix[row][column - 1] <= h) dfs(matrix, flagMatrix, row, column - 1, h);
        if (column + 1 < m && matrix[row][column + 1] <= h) dfs(matrix, flagMatrix, row, column + 1, h);
    }

    public static void dfs2(int[][] flagMatrix, int row, int column) {
        if (flagMatrix[row][column] == 0) return;
        flagMatrix[row][column] = 0;
        if (row - 1 >= 0) dfs2(flagMatrix, row - 1, column);
        if (row + 1 < n) dfs2(flagMatrix, row + 1, column);
        if (column - 1 >= 0) dfs2(flagMatrix, row, column - 1);
        if (column + 1 < m) dfs2(flagMatrix, row, column + 1);
    }
}