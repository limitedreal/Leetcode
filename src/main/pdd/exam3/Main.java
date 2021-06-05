package main.pdd.exam3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();
        char[] s = str.toCharArray();
        char[] map = new char[26];
        for (int i = 0;i<s.length;i++){
            map[s[i]-'a']++;
        }
        char[] result = dfs(s,n,map);
        if(result==null){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    public static char[] dfs(char[] s, int n, char[] map) {
        for (int i = s.length - 1; i >= 0; i--) {//我们这次改变第几位
            char c = s[i];
            while (s[i] >= 'a') {
                //判断是不是能被整除
                boolean flag = true;
                for (int j = 0; j < map.length; j++) {
                    if (map[j] % n != 0) {
                        flag = false;
                    }
                }
                if (flag) {
                    return s;
                }
                //下面开始操作map
                map[s[i] - 'a']--;
                s[i] = (char) (s[i] - 'a' - 1);
                if (s[i] >= 'a') {
                    map[s[i] - 'a']++;
                }
            }
            map[c - 'a']++;

        }
        return null;
    }

}
