package main.pdd.qiuzhao2.exam1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int o = 0; o < t; o++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            boolean[][] matrix = new boolean[h][w];
            sc.nextLine();
            for (int i = 0; i < h; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '*') {
                        matrix[i][j] = true;
                    }
                }
            }
            int cnt=0;
            boolean flag=true;
            for (int i = 0; i < h&&flag; i++) {
                for (int j = 0; j < w&&flag; j++) {
                    if(check(i,j,matrix)){
                        cnt++;
                        if(cnt>1){
                            flag=false;
                            break;
                        }
                    }
                }
            }
            if(cnt==1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean check(int row, int column, boolean[][] matrix) {
        if (!matrix[row][column]) {
            return false;
        }
        int low = row;
        int high = row;
        while (low >= 0 && high < matrix.length) {
            if (!(matrix[low][column] && matrix[high][column])) {
                // 有一个false
                if ((matrix[low][column] || matrix[high][column])) {
                    // 有一个true，另一个是false
                    return false;
                }
                // 两个都是false

                break;
            }
            low--;
            high++;
        }
        if(low==row-1&&high==row+1){
            return false;
        }
        if (low >= 0 && high == matrix.length) {
            if (matrix[low][column]) {
                return false;
            }
        }
        if (high < matrix.length && low == -1) {
            if (matrix[high][column]) {
                return false;
            }
        }
        low = column;
        high = column;
        while (low >= 0 && high < matrix[row].length) {
            if (!(matrix[row][low] && matrix[row][high])) {
                //有一个false
                if ((matrix[row][low] || matrix[row][high])) {
                    //有一个true，另一个是false
                    return false;
                }
                //两个都是false

                break;
            }
            low--;
            high++;
        }
        if(low==column-1&&high==column+1){
            return false;
        }
        if (low >= 0 && high == matrix[row].length) {
            if (matrix[row][low]) {
                return false;
            }
        }
        if (high <= matrix[row].length - 1 && low == -1) {
            if (matrix[row][high]) {
                return false;
            }
        }
        return true;

    }

}
