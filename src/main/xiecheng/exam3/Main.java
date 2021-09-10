package main.xiecheng.exam3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    int totalValue=0;


    public static void main(String[] args) {
        //不对，这是一个背包问题
        //完全背包问题，脑子昏了
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String arr = sc.nextLine();
        String[] split = arr.split("0+");
        int[] list = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            list[i] = split[i].length();
        }
        ArrayList<Integer> weights=new ArrayList<>();
        ArrayList<Integer> values=new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int weight = sc.nextInt();
            int score = sc.nextInt();
            weights.add(weight);
            values.add(score);
        }
        int result=0;
        for (String s : split) {
            beibao.packageweight=s.length();
            beibao.productnum=m;
        }

    }
    public static int solve(int[]price,int[] weight,int v){
        int len=price.length;
        int[] table=new int[len];
        int result=0;
        for (int i = 0; i < len; i++) {
            for (int j = weight[i]; j <= v; j++) {
                int r1=table[j-weight[i]];
                int r2=table[j];
                table[i]=Math.max(r1,r2);
            }
        }
        return 0;
    }



    static class beibao {
        static public int packageweight;
        static public int productnum;
        static public ArrayList<Integer> weights;
        static public ArrayList<Integer> values;
        static int[][] m;

        public static int[][] init() {
            m = new int[productnum + 1][packageweight + 1];
            return m;
        }

        public static int[][] result(int[][] arr) {
            for (int i = 1; i < productnum; i++) {
                for (int j = 1; j < packageweight; j++) {
                    if (weights.get(i - 1) > j) {
                        arr[i][j] = arr[i - 1][j];
                    } else {
                        arr[i][j] = Math.max(arr[i - 1][j],
                                arr[i - 1][j - weights.get(i - 1)] + values.get(i - 1));
                    }
                }
            }
            return arr;
        }


    }

}
