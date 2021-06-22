package main.LeetCode.o38;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class Solution {
    Set<String > result = new HashSet<>();
    public String[] permutation(String s) {
        char[] remain = s.toCharArray();
        char[] now = new char[remain.length];
        myPermutation(now,remain,0);
        String[] strings = result.toArray(new String[0]);
        return strings;
    }
    public void myPermutation(char[] pre,char[] preRemain, int index){
        //每次我们从preRemain中取出一个
        int n = pre.length;
        if(index==n){
            result.add(String.valueOf(pre));
            return;
        }
        for (int i = 0;i<n;i++){
            if(preRemain[i]=='\0'){
                continue;
            }
            char[] now = pre.clone();
            char[] remain =preRemain.clone();
            now[index] = preRemain[i];
            remain[i] = '\0';
            myPermutation(now,remain,index+1);
        }
    }

}
