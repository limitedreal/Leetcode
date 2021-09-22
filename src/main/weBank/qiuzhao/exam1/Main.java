package main.weBank.qiuzhao.exam1;

import java.util.Scanner;

public class Main {
    //public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //    int t = sc.nextInt();
    //    for (int o = 0; o < t; o++) {
    //        double k = sc.nextDouble();
    //        if (check(k)) {
    //            System.out.println("YES");
    //        } else {
    //            System.out.println("NO");
    //        }
    //
    //    }
    //}
    //
    //public static boolean check(double k) {
    //    int y = 1;
    //    while (Math.pow(y, 4) < k) {
    //        int z = 1;
    //        while (Math.pow(z, 5) < k) {
    //            double sqrt = Math.pow(k - Math.pow(y, 4) - Math.pow(z, 5), 1d / 3);
    //            if (sqrt > 0 && Math.abs(sqrt - Math.round(sqrt)) < Double.MIN_VALUE) {
    //                return true;
    //            }
    //            z++;
    //        }
    //        y++;
    //    }
    //    return false;
    //}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int o = 0; o < t; o++) {
            double k = sc.nextDouble();

            boolean flag = true;
            int z = 1;
            while (Math.pow(z, 5) < k && flag) {
                int y = 1;
                while (Math.pow(y, 4) < k && flag) {
                    int x = 1;
                    while (Math.pow(x, 3) < k && flag) {
                        if (Math.pow(x, 3) + Math.pow(y, 4)
                                + Math.pow(z, 5) == k) {
                            System.out.println("YES");
                            flag = false;
                        }
                        x++;
                    }
                    y++;
                }
                z++;
            }
            if (flag) {
                System.out.println("NO");
            }
        }
    }
}
