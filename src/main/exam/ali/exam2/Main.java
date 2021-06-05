//package main.exam.ali.exam2;
//
//import java.math.BigDecimal;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.close();
//        double result = 0;
//        for (int i = 1; i < n; i++) {
//            result+=burnAll1(i,n);
//        }
//        if(n==1){
//            System.out.println("1.0000");
//            return;
//        }
//        result/=(n-1);
//        System.out.println(result);
//        BigDecimal x = new BigDecimal(result);
//        x = x.setScale(4);
//        System.out.println(x.toString());
//        //HashMap
//        //sleep();
//        //wait();
//        Double a = 1.0;
//        java.math.BigDecimal x = new BigDecimal(5);
//        Integer.MAX_VALUE
//    }
//public static void Main(){
//
//}
//    public static double burnAll1(int location, int n) {
//        int min = Math.min(location, n - location), max = Math.max(location, n - location);
//        int cha = max - min;
//        double result2 = 0;
//        if (cha >= 2) {
//            for (int i = 1; i < cha; i++) {
//                result2 += burnAll2(i, cha);
//            }
//            result2 /= (cha - 1);
//        }
//        return min + result2;
//    }
//
//    public static double burnAll2(int location, int n) {
//        return Math.max(location, n - location);
//    }
//}
