package main.AIHomeWork.EightPuzzle;

import java.util.Scanner;

public class DFS {
    static int[][] target = new int[3][3];//= { { 1, 2, 3 }, { 8, 0, 4 }, { 7, 6, 5 } };
    //即要寻找的最终状态
    static int stepCount;        //用于记录移动步数
    static int depth = 5;    //用于记录深度

    public static void main(String[] args) {
        System.out.println("-------------------------八数码深度优先算法实现------------------------");
        int[][] arr1 = new int[3][3];    //定义二维数组
        Scanner input = new Scanner(System.in);
        System.out.println("请输入初始状态：");//创建键盘输入函数
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int ss = input.nextInt();
                arr1[i][j] = ss;
            }
        }
        System.out.println("请输入结果状态：");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int ss = input.nextInt();
                target[i][j] = ss;
            }
        }
        input.close();
         
        yidong(arr1, 1, 0);    //调用移动函数
        System.out.println("..................................................");
        System.out.println("没有找到");
    }

    public static void printMatrix(int a[][]) { // 输出二维数组

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean panduan(int a[][], int b[][]) { // 判断两个二维数组的内容是否相等
        boolean esta = true;

        for (int i = 0; i < a.length && esta == true; i++) {
            for (int j = 0; j < a[i].length && esta == true; j++) {
                if (a[i][j] != b[i][j]) {
                    esta = false;

                }
            }

        }
        return esta;
    }

    public static void jieshu() { // 结束函数
        stepCount++;    //移动步数
        System.out.println("结束");
        System.out.println("共用了" + stepCount + "步");
        System.exit(0);
    }

    public static int[][] zuoyi(int a2[][]) { // 还原左移函数

        int[][] a1 = a2;
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a1[i][j] == 0) {

                    n1 = i;// 移动格所在的行
                    n2 = j;// 移动格所在的列
                }
            }
        }
        int t1 = a1[n1][n2 + 1];
        a1[n1][n2 + 1] = a1[n1][n2];
        a1[n1][n2] = t1;
        return a1;
    }

    public static int[][] shangyi(int a2[][]) { // 还原上移函数
        int[][] a1 = a2;
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a1[i][j] == 0) {

                    n1 = i;// 移动格所在的行
                    n2 = j;// 移动格所在的列
                }
            }
        }
        int t1 = a1[n1 + 1][n2];
        a1[n1 + 1][n2] = a1[n1][n2];
        a1[n1][n2] = t1;
        return a1;
    }

    public static int[][] youyi(int a2[][]) { // 还原右移函数
        int[][] a1 = a2;
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a1[i][j] == 0) {

                    n1 = i;// 移动格所在的行
                    n2 = j;// 移动格所在的列
                }
            }
        }
        int t1 = a1[n1][n2 - 1];
        a1[n1][n2 - 1] = a1[n1][n2];
        a1[n1][n2] = t1;
        return a1;
    }

    public static int[][] xiayi(int a2[][]) { // 还原下移函数
        int[][] a1 = a2;
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a1[i][j] == 0) {
                    n1 = i;// 移动格所在的行
                    n2 = j;// 移动格所在的列
                }
            }
        }
        int t1 = a1[n1 - 1][n2];
        a1[n1 - 1][n2] = a1[n1][n2];
        a1[n1][n2] = t1;
        return a1;
    }

    public static void yidong(int a[][], int s, int x) {
        stepCount++;    //移动步数
        int[][] ar2 = a;    //传过来的数组
        int q = s;        //深度
        int c = x;        //用来判断不能向哪个方向移动（1，不能右移 2，不能下移 3，不能左移 4，不能上移）
        System.out.println("---------------第" + stepCount + "步---------------");
        System.out.println("深度：" + q);
        printMatrix(ar2);
        if (q == depth) {
            System.out.println("*********************************");
            System.out.println("到达设定的深度");
            System.out.println("*********************************");
        } else {
            int num1 = -1;
            int num2 = -1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (a[i][j] == 0) {

                        num1 = i;// 移动格所在的行
                        num2 = j;// 移动格所在的列
                    }
                }
            }
            int pan = c;
            int o = num2 - 1;
            // System.out.println(o);
            if (o < 0 || pan == 1) {        //左移
                //System.out.println("");
            } else {

                System.out.println("左移：");
                pan = 3;
                int t1 = ar2[num1][num2 - 1];
                ar2[num1][num2 - 1] = ar2[num1][num2];
                ar2[num1][num2] = t1;
                boolean aa = panduan(ar2, target);
                if (aa) {
                    System.out.println("right");
                    jieshu();
                } else {
                    yidong(ar2, q + 1, pan);
                    pan = c;
                    ar2 = zuoyi(ar2);        //调用左移还原函数
                    System.out.println("还原：");
                    printMatrix(ar2);
                     
                }
            }
            if (num1 - 1 < 0 || pan == 2) {        //上移
                //System.out.println("");
            } else {

                System.out.println("上移：");
                pan = 4;
                int t1 = ar2[num1 - 1][num2];
                ar2[num1 - 1][num2] = ar2[num1][num2];
                ar2[num1][num2] = t1;
                boolean aa = panduan(ar2, target);
                if (aa == true) {
                    System.out.println("right");
                    jieshu();
                } else {
                    yidong(ar2, q + 1, pan);
                    pan = c;
                    ar2 = shangyi(ar2);        //调用上移还原函数
                    System.out.println("还原：");
                    printMatrix(ar2);
                     
                }
            }
            if (num2 + 1 > 2 || pan == 3) {        //右移
                //System.out.println("");
            } else {

                System.out.println("右移：");
                pan = 1;
                int t1 = ar2[num1][num2 + 1];
                ar2[num1][num2 + 1] = ar2[num1][num2];
                ar2[num1][num2] = t1;
                boolean aa = panduan(ar2, target);
                if (aa == true) {
                    System.out.println("right");
                    jieshu();
                } else {
                    yidong(ar2, q + 1, pan);
                    pan = c;
                    ar2 = youyi(ar2);        //调用右移还原函数
                    System.out.println("还原：");
                    printMatrix(ar2);
                     
                }
            }
            if (num1 + 1 > 2 || pan == 4) {        //下移
                //System.out.println("");
                //;
            } else {

                System.out.println("下移：");
                pan = 2;
                int t1 = ar2[num1 + 1][num2];
                ar2[num1 + 1][num2] = ar2[num1][num2];
                ar2[num1][num2] = t1;
                boolean aa = panduan(ar2, target);
                if (aa == true) {
                    System.out.println("right");
                    jieshu();
                } else {
                    yidong(ar2, q + 1, pan);
                    pan = c;
                    ar2 = xiayi(ar2);        //调用下移还原函数
                    System.out.println("还原：");
                    printMatrix(ar2);
                     
                }

            }

        }
    }
}
/**
 * 1 2 3 8 0 4 7 6 5
 * 2 8 3 1 6 4 7 0 5
 * 2 8 3 1 0 4 7 6 5
 */
