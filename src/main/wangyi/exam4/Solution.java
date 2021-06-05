package main.wangyi.exam4;

import java.util.Comparator;

import static java.util.Arrays.sort;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        //{{0, 1, 3}, {1, 2, 2},{0, 2, 1}},3
        int[][]distance = {{0, 1, 3}, {1, 2, 2},{0, 2, 1}};
        int n = 3;
        System.out.println(s.GetBestWarehouseLocate(distance, n));
    }

    public int GetBestWarehouseLocate(int[][] distancePairs, int CityNum) {
        //首先要判断此图是否连通
        //这是什么方法呢？最短邻边法最小生成树
        int n = CityNum;
        int[][] adjacent = new int[n][n];
        sort(distancePairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        int[] bingcha = new int[n];
        for (int i = 0; i < bingcha.length; i++) {
            bingcha[i] = i;
        }
        for (int[] e : distancePairs) {
            if (findRoot(bingcha, e[0]) == findRoot(bingcha, e[1])) {
                //如果他们有相同的root，则说明成环，放弃
                continue;
            }
            int a = e[0], b = e[1];
            adjacent[a][b] = e[2];
            adjacent[b][a] = e[2];
            //下面要加入并查集
            int rootA = findRoot(bingcha, a);
            bingcha[rootA] = b;
        }
        //首先判断是否成环
        int root = findRoot(bingcha,0);
        for (int i : bingcha) {
            if(findRoot(bingcha,i)!=root){
                return -1;
            }
        }
        //再逐个寻找最优城市
        int city = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<n;i++){
            int cost = 0;
            for (int j = 0;j<n;j++){
                cost+=adjacent[i][j];
            }
            if(cost<min){
                city=i;
                min=cost;
            }
        }

        return city;
    }

    int findRoot(int[] bingcha, int target) {
        if (bingcha[target] == target) {
            return target;
        }
        int root = findRoot(bingcha, bingcha[target]);
        bingcha[target] = root;
        return root;
    }
    int dfs(int[][] adjacent,int target){
        int n = adjacent.length;
        for (int i = 0;i<n;i++){
            int cost = 0;
            int []road =new int[adjacent.length];
            for (int j = 0;j<n;j++){
                if(adjacent[i][j]!=0){
                    //road[j]=
                }
                cost+=adjacent[i][j];
            }

        }
        return 0;
    }


}
