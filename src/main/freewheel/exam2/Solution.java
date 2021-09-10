package main.freewheel.exam2;

import java.util.*;

public class Solution {
    //public static int maxPreRolDuration (int[][] orders) {
    //    //先试试贪心算法
    //    for (int[] order : orders) {
    //        Arrays.sort(order);
    //    }
    //    Arrays.sort(orders,(a,b)->{
    //        if(a[0]!=b[0]){
    //            return a[0]-b[0];
    //        }
    //        if(a[1]!=b[1]){
    //            return a[1]-b[1];
    //        }
    //        if(a[2]!=b[2]){
    //            return a[2]-b[2];
    //        }
    //        return 0;
    //    });
    //    int result=0;
    //    for (int i=0;i<orders.length;i++) {
    //        int max=0;
    //        for (int j=0;j< orders[i].length-1;j++) {
    //            max= Math.max(orders[i][j],max);
    //        }
    //        result+=max*orders[i][3];
    //    }
    //    return result;
    //}
    public static int maxPreRolDuration(int[][] orders) {
        //回溯法
        List<List<Integer>> lists = new ArrayList<>(orders.length + 1);
        for (int[] order : orders) {
            List<Integer> list = new ArrayList<>(order.length + 1);
            for (int i : order) {
                list.add(i);
            }
            lists.add(list);
        }
        int result = dfs(lists, new ArrayList<>(), 0);
        return result;
    }

    public static int dfs(List<List<Integer>> lists,List<List<Integer>> path, int pre) {
        if (lists.size() == 0) {
            int result=0;
            for (List<Integer> list : path) {
                result+=list.get(0);
            }
            return result;
        }
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {

            }
        }
        return  0;
    }

    public static void main(String[] args) {
        int[][] x = {{6, 4, 8, 30}, {15, 6, 3, 10}};
        System.out.println(maxPreRolDuration(x));
    }
}
