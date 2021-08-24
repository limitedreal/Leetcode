package main.iqiyi.exam2;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[] hash;
    public static int queenNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sss = sc.nextLine();
        StringBuilder s = new StringBuilder(sss);
        s.deleteCharAt(0);
        s.deleteCharAt(0);
        queenNum = Integer.parseInt(s.toString());
        hash = new int[queenNum + 1];
        for (int i = 0; i < queenNum + 1; i++) {
            hash[i++] = -1;
        }
        System.out.print("[");
        placeQueen(1);
        System.out.print("]");
    }


    public static void placeQueen(int m) {
        if (m > queenNum) {
            for (int i = 1; i <= queenNum; i++) {
                int column = hash[i];
                StringBuilder sb = new StringBuilder();
                System.out.print("[");
                for (int j = 1; j <= queenNum; j++) {

                    if (j != column) {
                        System.out.print(".");
                    } else {
                        System.out.print("Q");
                    }
                }
                System.out.print("]");
            }
            return;
        }
        for (int i = 0; i < queenNum; i++) {
            if (isConflict(m, i)) {
                continue;
            } else {
                hash[m] = i;
                placeQueen(m + 1);
                hash[m] = -1;
            }
        }
    }

    public static boolean isConflict(int row, int column) {
        if (row == 1) {
            return false;
        }
        for (int i = 1; i < row; i++) {
            if (hash[i] == column || (column - row) == (hash[i] - i)
                    || (row - column) == (i) - hash[i]
            || (row+column)==(hash[i]+i)){
                return true;
            }

        }
        return false;
    }
}
