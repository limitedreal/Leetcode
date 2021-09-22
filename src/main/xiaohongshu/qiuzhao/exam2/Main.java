package main.xiaohongshu.qiuzhao.exam2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //其实就是为了寻找排序后的交换次数
        int n = sc.nextInt();
        int[]nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        int result=calculate(nums);
        System.out.println(result);
    }
    public static int calculate(int[]nums){
        int n=nums.length;
        //并不是想要排序，仅仅是
        int[]sorted= Arrays.copyOf(nums,n);
        Arrays.sort(sorted);
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sorted[i],i);
        }
        boolean[] flag=new boolean[n];
        int cnt=0;
        for (int i = 0; i < n; i++) {
            if(flag[i]){
                continue;
            }
            int index=i;
            while (!flag[index]){
                flag[index]=true;
                index=map.get(nums[index]);
            }
            cnt++;
        }
        return n-cnt;
    }
}
