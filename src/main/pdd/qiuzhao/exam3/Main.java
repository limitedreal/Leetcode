package main.pdd.qiuzhao.exam3;

import java.math.BigInteger;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String result = e3(n, m);
            System.out.println(result);
        }
    }

    public static String e3(int nvalue, int mvalue) {
        BigInteger m=new BigInteger(String.valueOf(mvalue));
        BigInteger n=new BigInteger(String.valueOf(nvalue));
        StringBuilder mins=new StringBuilder("1");
        StringBuilder maxs=new StringBuilder("10");
        for (int i = 1; i < nvalue; i++) {
            mins.append('0');
            maxs.append('0');
        }
        BigInteger min=new BigInteger(mins.toString());
        BigInteger max=new BigInteger(maxs.toString());
        BigInteger result=new BigInteger("0");
        BigInteger multi=new BigInteger("1");
        BigInteger plus=new BigInteger("1");
        while (result.compareTo(max)<0){
            result=m.multiply(multi);
            if(result.compareTo(min)>=0&&result.compareTo(max)<0){
                return result.toString();
            }
            multi=multi.add(plus);
        }
        return "-1";
        //while (result.compareTo(min))
    }
}
