package main.shenxinfu.exam1;

public class Solution {

    public int ncov_defect(int[][] grid) {
        //[[0,1,0,0,0,0,0,1],
        // [0,1,0,0,0,0,0,1],
        // [0,0,0,0,0,0,0,1],
        // [0,0,0,0,0,0,0,0]]
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    //东西南北
                    int row = i;
                    int column = j;
                    while (row >= 0) {

                        if (grid[row][column] != 1) {
                            grid[row][column] = 2;
                            break;
                        }
                        row--;
                    }
                    row = i;
                    column = j;
                    while (row < grid.length) {

                        if (grid[row][column] != 1) {
                            grid[row][column] = 2;
                            break;
                        }
                        row++;
                    }
                    row = i;
                    column = j;
                    while (column < grid[i].length) {

                        if (grid[row][column] != 1) {
                            grid[row][column] = 2;
                            break;
                        }
                        column++;
                    }
                    row = i;
                    column = j;
                    while (column >= 0) {

                        if (grid[row][column] != 1) {
                            grid[row][column] = 2;
                            break;
                        }
                        column--;
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}