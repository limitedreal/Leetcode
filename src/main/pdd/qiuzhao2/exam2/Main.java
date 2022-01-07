package main.pdd.qiuzhao2.exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //我们先判断这个字符串有没有其他字符
        if(!(s.contains("a")&&s.contains("b"))){
            System.out.println(s);
        }
        StringBuilder sb=new StringBuilder(s);
        int index = sb.indexOf("ab");
        StringBuilder result=new StringBuilder();
        while (index!=-1){
            if(index==0){
                if(index+2<sb.length()){

                }else{

                }
            }
        }


    }
}
