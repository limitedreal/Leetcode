package main;

import java.util.Scanner;
import java.io.*;

import java.lang.*;

public class Nhuanghouwenti{
    public static double smallest_k(double x_val, double k_val){
        double val = 10;

        double MIN = Math.pow(val, k_val - 1);

        if (MIN % x_val == 0)

            return (MIN);

        else

            return ((MIN + x_val) - ((MIN + x_val) % x_val));

    }

    public static void main(String[] args){
        double x_val = 76;

        double k_val = 3;

        System.out.println("可被x整除的最小k位数字为 ");

        System.out.println((int)smallest_k(x_val, k_val));

    }

}
 class Nhuansghouwenti {

    private static int queenNum;//皇后的个数
    private static int[] hash;//下标表示i号皇后（皇后i放在第i行）value表示放的列号
    private static int count = 0;//合法摆放方式的个数

    public static void placeQueen(int m) {
        if (m > queenNum) {//如果摆到了n+1行了，说明前n行都是不冲突的，合法的
            count++;
            for (int i = 1; i <= queenNum; i++) {
                System.out.print(hash[i]);
            }
            System.out.println();
//	            System.out.println(Arrays.toString(hash));
            //打印合法的摆放结果
//	            for(int i = 1; i <= queenNum; i++){
//	                int column = hash[i];//hash值表示皇后i所在的列号
//	                for(int j = 1; j <= queenNum ;j++){
//	                    if(j!= column){
//	                        System.out.print("* ");
//	                    }else{
//	                        System.out.print("Q ");
//	                    }
//	                }
//	                System.out.println();
//	            }
            return;
        }
        for (int i = 1; i <= queenNum; i++) {
            //check the column is conflict with former ones or not
            //if so, check the next column until find a non-conflict column
            //or until the last column ,return;
            if (isConfilct(m, i)) {
                continue;
            } else {//如果检测到第i列不冲突，是安全的，
                hash[m] = i;//将皇后m放在第i列
                placeQueen(m + 1);//再放皇后m+1,
                //如果皇后m+1放完并返回了
                //两种可能：
                //1：冲突，返回了
                //2.一直将所有的皇后全部放完并安全返回了
                //将皇后m回溯，探索新的可能或者安全的位置
                hash[m] = -1;
                //其实这里没必要将m重新赋值的，因为检测到下一个
                //安全位置的时候会把hash[m]覆盖掉的
                //但是为了更好的体现“回溯”的思想，在这里画蛇添足了
            }
        }
    }


    private static boolean isConfilct(int row, int column) {  //一行一个皇后，第n个皇后也代表着第n行
        if (row == 1) {//第1行永远不会冲突
            return false;
        }
        //只需要保证与那些已经就位的皇后不冲突即可
        for (int i = 1; i < row; i++) {  //当前的行数
            if (hash[i] == column || (column - row) == (hash[i] - i) || (row - column) == (i - hash[i])
                    //以前行数减列数与现在的是否相等
                    || (row + column) == (hash[i] + i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queenNum = sc.nextInt();
        hash = new int[queenNum + 1];
        for (int i = 0; i < hash.length; hash[i++] = -1) {
            ;//初始化棋盘
        }
        placeQueen(1);
        System.out.println(count);
    }

}


