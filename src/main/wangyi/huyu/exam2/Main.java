package main.wangyi.huyu.exam2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int k = 0;k<n;k++){
            int[] s = null,e=null;
            int w=sc.nextInt(),h=sc.nextInt();
            char[][] migong = new char[h][];
            for (int i = 0;i<h;i++){
                //读取迷宫
                for (int j = 0; j < w; j++) {
                    migong[i]=sc.nextLine().toCharArray();
                    if(s==null||e==null){
                        for (int m = 0; m < migong[i].length; m++) {
                            if(migong[i][m]=='E'){
                                e= new int[]{i, m};
                            }
                            if(migong[i][m]=='S'){
                                s= new int[]{i, m};
                            }
                        }
                    }

                }
                //因为起点可能在墙壁的四周，这样初始就要有4个前进方向
                //所以要不要先把矩阵做旋转，但是旋转也蛮麻烦的
                //那么怎么保证它一直往左走呢，应该按照现在的方向，
                //下一步前进方向总是逆时针旋转的


            }
        }

    }
}
