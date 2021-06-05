package main.duxiaoman.exam2;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<Integer[]>[] lists = new LinkedList[26];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        String str = sc.next();
        sc.close();
        //我们可以通过dfs的方法
        //但是现在我们采用更好的方法，记录下每个颜色的起始和连续长度，
        //然后递归改变每个颜色的间隔
        for (int i = 0;i<26;i++){
            lists[i]=new LinkedList<>();
        }
        char pre = '#';
        int count=0;
        for (int i = 0;i<n;i++){
            char now = str.charAt(i);
            if(now==pre){
                count++;
            }else{
                if(pre!='#'){
                    lists[pre-'a'].add(new Integer[]{i-count, count});
                    count=0;
                }
                pre=now;
                count++;
            }
        }
        lists[pre-'a'].add(new Integer[]{n-count, count});

    }
    public static void dfs(int remain,char target,LinkedList<Integer[]> list){
        //可以选择填充或者不填充这个空隙
        for (Integer[] item : list) {

        }

    }

}
