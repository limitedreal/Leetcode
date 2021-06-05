package main.weBank.exam3;

import java.util.*;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //首先数字的末尾必须是一个0，前导不能是0
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> remain = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                remain.add(sc.nextInt());
            }
            //dfs()
        }
    }

    public static int dfs(List<Integer> preRemain, List<Integer> preResult, int now, int depth) {
        List<Integer> remain =preRemain,result = preResult;
        if(depth!=0){//此时要去除、添加now，并且复制两个list
            remain = new ArrayList<>(preRemain);
            result = new ArrayList<>(preResult);
            remain.remove(now);
            result.add(now);
        }
        int n1 = remain.size(), n2 = result.size(), n = n1 + n2;
        if(n1==0){
            int k = 0;
            for (Integer item : result) {
                k=k*10+item;
            }
            if(k%30==0){
                return k;
            }
            return -1;
        }
        int k = -1;
        for (int i = 0; i < n1; i++) {
            if (depth == 0) {//第一位肯定不能是0，剪枝
                if (remain.get(i) == 0) {
                    continue;
                }
            }
            k = max(dfs(remain,result,remain.get(i),depth+1),k);
        }
        return k;
    }
}
