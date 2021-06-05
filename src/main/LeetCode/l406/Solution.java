package main.LeetCode.l406;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class Struct{
        int height;
        int front;
        Struct struct = null;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(list.indexOf(2));
        System.out.println(list.lastIndexOf(2));
        list.add(2,list.lastIndexOf(2));
    }
    public static int[][] reconstructQueue(int[][] people) {
        //首先，改造成双向链表
        Struct now;//这里印证了方法中的局部变量是没有初值的，不会经历类变量的加载过程

        int n = people.length;
        //while (now==null){//当最后一个比对完时结束
        //
        //}
        //转换成二维数组返回

        return null;
    }
    public static int moveCount(){//到底要移动多少步，+-0
return 0;
    }
    public static Struct changeToLinkedList(int[][] people){
return null;
    }
}
