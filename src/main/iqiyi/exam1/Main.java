package main.iqiyi.exam1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] split = s.split(",");
            int[] target = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                target[i] = Integer.parseInt(split[i]);
            }
            int result = doCheck(target);
            System.out.println(result);
        }
    }

    public static int doCheck(int[] target) {
        //根据其增长和下落分别调用两个函数
        if (target.length < 2) {
            System.out.println(0);
            return 0;
        }
        boolean zeng = target[0] <= target[1];
        int start = 0;
        int result = 0;
        int n = target.length;
        for (int i = 0; i < n - 1; i++) {
            if (target[i] < target[i + 1]) {
                if (!zeng) {
                    zeng = true;
                    result = Math.max(result,
                            Math.abs(target[i] - target[start]));
                    start = i;
                }
            } else {
                if (zeng) {
                    zeng = false;
                    result = Math.max(result,
                            Math.abs(target[i] - target[start]));
                    start = i;
                }
            }
        }
        result = Math.max(result,
                Math.abs(target[n - 1] - target[start]));
return result;
    }

    public static int zeng() {
        return 0;
    }

    public static int jiang() {
        return 0;
    }
}
