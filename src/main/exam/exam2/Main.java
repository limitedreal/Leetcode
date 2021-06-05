package main.exam.exam2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //是不是说可能有特别大的数字？
        BigDecimal k = new BigDecimal("5648568");
        BigDecimal r = new BigDecimal("112");
        int i1 = k.compareTo(r);

        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        int n = target.length();
        ArrayList<BigDecimal> result = new ArrayList<BigDecimal>();
        String temp = "";
        for (int i = 0;i<n;i++){
            if(target.charAt(i)>='0'&&target.charAt(i)<='9'){
                temp+=target.charAt(i);
            }else{
                if(temp.length()!=0){
                    BigDecimal now = new BigDecimal(temp);
                    result.add(now);
                    temp="";
                }
            }
        }

        if(temp.length()!=0){
            BigDecimal now = new BigDecimal(temp);
            result.add(now);
            temp="";
        }
        // sort的使用方法
        //Collections.sort(result,new Comparator<BigDecimal>(){
        //
        //    @Override
        //    public int compare(BigDecimal o1, BigDecimal o2) {
        //        return o1.compareTo(o2);
        //    }
        //});
        Object[] results = result.toArray();
        //Arrays.sort(objects);

        //大.小返回1
        for (int i = 0;i<results.length;i++){
            for (int j = i;j<results.length;j++){
                BigDecimal a = (BigDecimal)results[i];
                BigDecimal b = (BigDecimal)results[j];
                if(a.compareTo(b)==1){
                    //如果i比j大
                    Object t = results[i];
                    results[i] = results[j];
                    results[j] = t;
                }
            }
        }
        int i;
        for ( i = 0;i<results.length-1;i++){
            System.out.println(results[i].toString());
        }
        System.out.print(results[i].toString());
    }
}
