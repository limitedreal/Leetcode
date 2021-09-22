package main.meituan.qiuzhao.exam1;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    //public static void main(String[] args) {
    //    Scanner sc=new Scanner(System.in);
    //    String s = sc.nextLine();
    //    long cnt=0;
    //    int n=s.length();
    //    BigDecimal t=new BigDecimal(22);
    //    BigDecimal z=new BigDecimal(0);
    //    for (int i = 0; i < n; i++) {
    //        for (int j = i+1; j < n; j++) {
    //            BigDecimal big=new BigDecimal(s.substring(i,j));
    //            BigDecimal[] amt = big.divideAndRemainder(t);
    //            if(amt[1].equals(z)){
    //                cnt++;
    //            }
    //        }
    //    }
    //    System.out.println(cnt);
    //}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        long cnt=0;
        int n=s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                Long big=Long.parseLong(s.substring(i,j));
                if(big%22==0){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
