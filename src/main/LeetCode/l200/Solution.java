package main.LeetCode.l200;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}};
        System.out.println(s.numIslands(grid));

    }

    public int numIslands(char[][] grid) {
        int result = 0;
//        Deque<Integer[]> deque = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    //开始深度优先遍历
//                    grid[i][j]='0';
//                    Integer[] item={i,j};
//                    deque.add(item);
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        if (i - 1 >= 0) {
            dfs(grid, i - 1, j);
        }
        if (j - 1 >= 0) {
            dfs(grid, i, j - 1);
        }
        if (i + 1 < grid.length) {
            dfs(grid, i + 1, j);
        }
        if (j + 1 < grid[0].length) {
            dfs(grid, i, j + 1);
        }
    }
}
