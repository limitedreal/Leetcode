package main.weBank.qiuzhao.exam2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.nextLine();
        String str = sc.nextLine();
        char[] orders = str.toCharArray();
        int row = 0;
        int column = 0;
        long power = 0L;
        char pre = orders[0];
        for (char order : orders) {
            switch (order) {
                case 'k': {
                    //左
                    if (row == 0 || matrix[row - 1][column] == -1) {
                        power += y;
                        break;
                    }
                    power += Math.max(matrix[row - 1][column], matrix[row][column]);
                    row--;
                    break;
                }
                case 'h': {
                    //下
                    if (column == 0 || matrix[row][column - 1] == -1) {
                        power += y;
                        break;
                    }
                    power += Math.max(matrix[row][column - 1], matrix[row][column]);
                    column--;
                    break;
                }
                case 'l': {
                    //上
                    if (column == m - 1 || matrix[row][column + 1] == -1) {
                        power += y;
                        break;
                    }
                    power += Math.max(matrix[row][column + 1], matrix[row][column]);
                    column++;
                    break;
                }
                case 'j': {
                    //右
                    if (row == m - 1 || matrix[row + 1][column] == -1) {
                        power += y;
                        break;
                    }
                    power += Math.max(matrix[row + 1][column], matrix[row][column]);
                    row++;
                    break;
                }
                default: {

                }


            }
            if (order != pre) {
                power += x;
                pre = order;
            }

        }
        System.out.println(power);
    }
}
