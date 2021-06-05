package main.LeetCode.l38;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static Set<String > result = new HashSet<>();
    static int length;
    public static void main(String[] args) {
        //char[] x = {'a','b','t'};
        //System.out.println(String.valueOf(x));
        //System.out.println(new String(x));
        //char[] x = new char[0];
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        length = str.length();
        String[] strings = permutation(str);
        for (String s :strings ) {
            System.out.println(s);
        }
    }

    public static String[] permutation(String s) {
        char[] remain = s.toCharArray();
        char[] now = new char[0];
        myPermutation(now,remain,0);
        String[] strings = result.toArray(new String[0]);
        return strings;
    }
    public static void myPermutation(char[] pre,char[] preRemain, int index){
        //每次我们从preRemain中取出一个
        int n = preRemain.length;
        if(index==length){
            result.add(String.valueOf(pre));
            return;
        }
        for (int i = 0;i<n;i++){
            if(preRemain[i]=='\0'){
                continue;
            }
            char[] now = new char[pre.length+1];
            for (int j = 0;j<pre.length;j++){
                now[j] = pre[j];
            }
            char[] remain =new char[preRemain.length-1];
            int k = 0;
            for (int j = 0;j<preRemain.length;j++){
                if(j!=i){
                    remain[k]=preRemain[j];
                    k++;
                }
            }
            now[index] = preRemain[i];
            myPermutation(now,remain,index+1);
        }
    }

}
