package main.wangyi.huyu.exam3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //其实或许不需要每次都重新排序
        //我们实际上只要每次更新/添加的时候维护中位数的位置就可以了
        //其实是一种选择插入法，查找方式就用二分法了
        //Treemap和这种选择插入法，到底哪个好点呢？
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int gift=0;
            int n =sc.nextInt();
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            for (int q = 0; q < n; q++) {
                //用分数作为key，用id作为value
                int p=sc.nextInt(),s=sc.nextInt();
                if(!treeMap.containsValue(p)){//如果不存在p这个id的
                    treeMap.put(s,p);
                }else if(treeMap.get(p)>=s){
                    continue;
                }

                Collection<Integer> set = treeMap.values();
                Iterator<Integer> iterator = set.iterator();
                Integer item=0,pre=0;
                int m = set.size();
                double mid=-1;//左中位数和右中位数
                int index = 0;
                int count=0;
                boolean flag=(m%2!=0);
                //我应该直接在循环里确定中位数
                while (iterator.hasNext()){
                    item = iterator.next();
                    index++;
                    if(flag){//如果m是奇数
                        if(index==m/2+1){
                            mid=item;
                            break;
                        }

                    }else{
                        if(index==m/2){
                            mid=(item+iterator.next())/2.0;
                            break;
                        }
                    }
                }
                if(mid==p){
                    gift++;
                }
            }
            System.out.println(gift);
        }
    }
}
