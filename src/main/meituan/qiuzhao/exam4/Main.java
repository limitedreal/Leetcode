package main.meituan.qiuzhao.exam4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int q=sc.nextInt();
        for (int o = 0; o < q; o++) {
            int u=sc.nextInt();
            int k=sc.nextInt();
            boolean f=true;
            char c;
            int cnt=0;
            for (int i = 1; i <=u; i++) {
                //周期的长度
                boolean flag=true;
                for(int j=0;j<u-i;j++){
                    //查询这个周期是否成立
                    c=chars[j];
                    if(chars[j+i]!=c){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    cnt++;
                    if(cnt==k){
                        f=false;
                        System.out.println(i);
                        break;
                    }
                }
            }
            if(f){
                System.out.println(-1);
            }
        }
    }
}
