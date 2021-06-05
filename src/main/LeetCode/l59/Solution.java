package main.LeetCode.l59;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] ints = s.generateMatrix(1);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int direct = 0;//0右1下2左3上
        int column = 0, row = 0;
        for (int i = 1; i < n * n; i++) {
            switch (direct) {
                case 0: {//向右
                    result[row][column] = i;
                    if (column >= n - 1 || result[row][column + 1] != 0) {//说明不能往右走了
                        direct = (direct + 1) % 4;
                        i--;
                    } else {
                        column++;
                    }
                    break;
                }
                case 1: {//向下
                    result[row][column] = i;
                    if (row >= n - 1 || result[row + 1][column] != 0) {
                        direct = (direct + 1) % 4;
                        i--;
                    } else {
                        row++;
                    }
                    break;
                }
                case 2: {//向左
                    result[row][column] = i;
                    if (column == 0 || result[row][column - 1] != 0) {//说明不能往右走了
                        direct = (direct + 1) % 4;
                        i--;
                    } else {
                        column--;
                    }
                    break;
                }
                case 3: {//向上
                    result[row][column] = i;
                    if (row == 0 || result[row - 1][column] != 0) {//说明不能往右走了
                        direct = (direct + 1) % 4;
                        i--;
                    } else {
                        row--;
                    }
                    break;
                }
            }
        }
        result[row][column]=n*n;
        return result;
    }
}
