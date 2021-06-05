package main.jd.exam2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] flagMatrix = new int[n][m];
        //现在我们循环查找
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (flagMatrix[i][j] != 0) {
                    continue;
                }
                digui(matrix, flagMatrix, i, j);//因为在递归中标记了-1，所以这里要进行还原
                for (int k = 0; k < n; k++) {
                    for (int t = 0; t < m; t++) {
                        if(flagMatrix[k][t]==-1){
                            flagMatrix[k][t]=0;
                        }
                    }
                }
            }
        }
        int keng = 0;
        //下面我们的任务是找到和统计成片的水坑
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                //思路仍然是递归地标记水坑，每次标记完一个水坑就+1
                if (flagMatrix[i][j] == 1) {
                    digui2(flagMatrix,i,j);
                    keng++;
                }
            }
        }
        System.out.println(keng);
    }

    //一个递归查找水的流向的函数
    public static boolean digui(int[][] matrix, int[][] flagMatrix, int row, int column) {
        //一个坑，可能向四个方向扩展，返回true说明这个方向可以生成坑
        if (flagMatrix[row][column] ==1 || flagMatrix[row][column] ==-1) {
            //有坑或者别的地方探查过了，就可以直接return true
            return true;
        }
        if(flagMatrix[row][column]==0){
            flagMatrix[row][column]=-1;//标记在递归中这个地方来过了
        }
        if (row == 0 || row == matrix.length - 1 || column == 0 || column == matrix[0].length - 1) {
            return false;//碰到边界了，水从这里流出
        }
        boolean up = true, down = true, left = true, right = true;
        int now = matrix[row][column];
        //说明水会向这个方向流动
        if (now >= matrix[row - 1][column]) {//向上
            up = digui(matrix, flagMatrix, row - 1, column);
        }
        if (now >= matrix[row + 1][column]) {//向下
            down = digui(matrix, flagMatrix, row + 1, column);
        }
        if (now >= matrix[row][column - 1]) {//向左
            left = digui(matrix, flagMatrix, row, column - 1);
        }
        if (now >= matrix[row][column + 1]) {//向右
            right = digui(matrix, flagMatrix, row, column + 1);
        }
        boolean result = up && down && left && right;
        if (result) {
            flagMatrix[row][column] = 1;
        }
        return result;
    }
    //一个递归标记水坑的函数
    public static void digui2(int[][] flagMatrix, int row, int column) {
        if(flagMatrix[row][column]!=1){
            return;
        }
        flagMatrix[row][column]=2;
        digui2(flagMatrix,row+1,column);
        digui2(flagMatrix,row-1,column);
        digui2(flagMatrix,row,column+1);
        digui2(flagMatrix,row,column-1);
    }

}
