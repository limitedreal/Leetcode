package main.LeetCode.l149;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer,Integer> map;
    public static void main(String[] args) {
        //int [][] k={{7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},{-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},{-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},{10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},{-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},{-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},{-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},{9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},{15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},{4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},{-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},{5,-17},{6,-6},{-11,-8}};
        int[][]k={{0,0}};
        Solution s=new Solution();
        System.out.println(s.maxPoints(k));
    }
    public int maxPoints(int[][] points) {
        int result=0;
        int[] t=new int[2];
        for (int i=0;i<points.length-1;i++){
            map=new HashMap<>();
            for (int j=i+1;j<points.length;j++){
                t[0]=points[i][0]-points[j][0];
                t[1]=points[i][1]-points[j][1];
                simplify(t);
                storage(t);
            }
            for (Integer value : map.values()) {
                result=Math.max(result,value+1);
            }
        }
        return Math.max(result,1);
    }

    public void storage(int[] target){
        int t=target[0]*2*10000+target[1];
        if(map.containsKey(t)){
            map.put(t,map.get(t)+1);
        }else{
            map.put(t,1);
        }
    }


    public void simplify(int[] target) {
        //辗转相除法
        //化简的方法存在两种规定
        //如果其中一个为0，另一个为1
        //如果分子为负数，那么两数取相反数，分子规定为target[0]
        if (target[0] == 0) {
            target[1] = 1;
        } else if (target[1] == 0) {
            target[0] = 1;
        } else {
            int a = Math.max(target[0], target[1]), b = Math.min(target[0], target[1]);
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            //此时a是最大公约数
            target[1] /= a;
            target[0] /= a;
            if (target[0] < 0) {
                target[0] = -target[0];
                target[1] = -target[1];
            }
        }
    }
}
