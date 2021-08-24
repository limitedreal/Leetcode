package main.pdd.qiuzhao.exam4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //if(Double.MAX_VALUE>100000000000L){
        //    double g=0;
        //}
        Scanner sc = new Scanner(System.in);
        double t = sc.nextDouble();
        for (double o = 0; o < t; o++) {
            int n = sc.nextInt();
            double k = sc.nextDouble();
            double d = sc.nextDouble();
            double q = sc.nextDouble();
            double[] location = new double[n];
            double[] lao = new double[n];
            boolean flag = false;
            for (double day = 0; day < k; day++) {
                double laozhi = sc.nextDouble();
                int index = sc.nextInt();
                if (flag) {
                    continue;
                }
                lao[index] = laozhi;
                location[index] = laozhi;
                for (int i = 1; i <= d; i++) {
                    if (index + i < n&&!flag) {
                        location[index] += lao[index + i];
                        location[index + i] += laozhi;
                        if (location[index + i] >= q) {
                            System.out.println((int)day);
                            flag = true;
                            break;
                        }
                    }
                    if (index - i >= 0) {
                        location[index] += lao[index - i];
                        location[index - i] += laozhi;
                        if (location[index - i] >= q&&!flag) {
                            System.out.println((int)day);
                            flag = true;
                            break;
                        }
                    }
                    if(location[index]>=q&&!flag){
                        System.out.println((int)day);
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                System.out.println(-1);
            }
        }
    }
}
