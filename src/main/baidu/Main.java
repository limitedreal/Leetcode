package main.baidu;

import java.util.*;

public class Main {

    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();
        int W = sc.nextInt();
        int a=0;
        find(0, L, R, W);
    }

    public static void find(int empty, int ocupy, int R, int W) {
//是否可以先读
        if (R <= ocupy) {
            if (solution(empty + R, ocupy - R, R, W)) {
                System.out.println("OK");
                return;
            }


        }
//是否可以先写
        // 修复完成
        if (W <= empty) {
            if (solution(empty - W, ocupy, R, W)) {
                System.out.println("OK");
                return;
            }
        }
        System.out.println("DEADLOCK");
    }

    public static boolean solution(int empty, int ocupy, int R, int W) {
        if (map.containsKey(empty)) {
            if (map.get(empty) == ocupy) {
                return true;
            }
        }
        map.put(empty + R, ocupy - R);
//是否可以先读
        if (R <= ocupy) {
            if (solution(empty + R, ocupy - R, R, W)) {
                return true;
            }
        }
//是否可以先写
        if (W <= empty) {
            if (solution(empty - W, ocupy, R, W)) {
                return true;
            }
        }
        return false;
    }
}
