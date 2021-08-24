//package main.jd.qiuzhao.exam2;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        char[] str = sc.nextLine().toCharArray();
//        int[] zero = new int[n];
//        int[] one = new int[n];
//
//        for (int i = 0; i < str.length; i++) {
//            switch (str[i]) {
//                case '0': {
//                    zero[i]++;
//                    break;
//                }
//                case '1': {
//                    one[i]++;
//                    break;
//                }
//                default: {
//                }
//            }
//            int zcnt = 0;
//            int ocnt = 0;
//            int zt = zero[i];
//            int ot = one[i];
//            int gcd = gcd(zt, ot);
//            zt/=gcd;
//            ot/=gcd;
//            //我想不到什么好方法，现在尝试用比例不断扩张
//            int cnt=0;
//            boolean flag=false;
//            while (zt + ot < i + 1) {
//                if(zero[zt+ot]==zt&&one[zt+ot==ot]){
//
//                }
//            }
//
//
//        }
//
//    }
//
//    public static int gcd(int m, int n) {
//        int rem = 0;
//        if (n == m) {
//            return m;
//        }
//        if (n > m) {
//            int t = m;
//            m = n;
//            n = t;
//        }
//        while (n > 0) {
//            rem = m % n;
//            m=n;
//            n=rem;
//        }
//        return m;
//    }
//}
