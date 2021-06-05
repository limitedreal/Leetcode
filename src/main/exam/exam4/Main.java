package main.exam.exam4;

import java.util.*;

public class Main {
    static int n, m;
    static int[] weight;
    static int[][] adjacentMatrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //动态规划？选择他和不选择他的最优情况分别记下来
        //可以先写一份暴力的
        n = sc.nextInt();
        m = sc.nextInt();
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        adjacentMatrix = new int[n][n];
        for (int i = 0; i < m; i++) {
            int t1 = sc.nextInt() - 1, t2 = sc.nextInt() - 1;
            adjacentMatrix[t1][t2] = 1;
            adjacentMatrix[t2][t1] = 1;
        }
        sc.close();
        //前期准备完成
        //广度搜，先往左搜再往右搜
        int[] road = new int[0];


    }

    public static int[] boardSearch(int start, int[] preRoad, int preWeight, int mini) {
        //返回一个两个元素的数组，第一个是权值，第二个是最小值
        // 1. 记录哪些选过了哪些没选过
        // 2. 沿着边走，且不许回头
        //start指定现在这个点是哪个点
        int[] road = preRoad.clone();
        for (int i = 0; i < n; i++) {
            if (adjacentMatrix[start][i] == 1) {//找到一个边，顺着找下去
                if (road[i] != 1) {//不包含此结点
                    //先走一个不选，再走一个选的
                    boardSearch(i, road, preWeight, mini);
                    road[i] = 1;
                    if (weight[i] < mini) {
                        mini = weight[i];
                    }
                    int[] noChoose = boardSearch(i, road, preWeight + weight[i], mini);
                    System.out.println();
                }
            }
        }
        return null;
    }
}
