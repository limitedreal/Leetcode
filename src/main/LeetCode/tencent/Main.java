package main.LeetCode.tencent;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，
        //各个字符的相对位置不变，且不能申请额外的空间。你能帮帮小Q吗？
        //int k = 'a';
        //System.out.println(k);
        //k='z';
        //System.out.println(k);
        //k='A';
        //System.out.println(k);
        //k='Z';
        //System.out.println(k);
        String target = "BCDaKasE";
        char[] result =target.toCharArray();
        //putUpperBehind(result,0);
        manli(result);
        System.out.println(Arrays.toString(result));
    }
    static void manli(char[]target){
        int n=target.length;
        for (int i=0;i<n;i++){
            if(target[i]>='A'&&target[i]<='Z'){
                char temp = target[i];
                for (int j=i;j<target.length-1;j++){
                    target[j] = target[j+1];
                }
                target[target.length-1]=temp;
                i--;
                n--;
            }
        }
        return;
    }
    static int putUpperBehind(char[] target,int now){
        //此函数的返回值是每次递归把大写字母插入的index
        //1.暴力换
        //2.递归
        int n = target.length;
        int b=n;
        char temp='0';
        while(now<n){
            if(target[now]>='A'&&target[now]<='Z'){
                temp = target[now];
                target[now] = '0';
                b=putUpperBehind(target,now);
                break;
            }
            now++;
        }
        if(now==n){
            for (int i = 0;i<n;i++){//先把小写字母往前移动
                if(target[i]=='0'){
                    //往后找到第一个不是0的
                    boolean hasFindLow=false;//后面还有没有小写字母了？
                    for (int j=i;j<n;j++){
                        if(target[j]!='0'){
                            target[i]=target[j];
                            target[j]='0';
                            hasFindLow=true;
                            break;
                        }
                    }
                    if(!hasFindLow){//如果后面已经没有小写字母了，那就可以开始动大写字母了
                        break;
                    }
                }
            }
        }
        if (temp != '0') {
            //temp为'0'的话说明这一轮就没有找到大写字母，可能是
            b--;
            if(target[b]=='0'){
                target[b]=temp;
            }
        }
        return b;
    }
}
