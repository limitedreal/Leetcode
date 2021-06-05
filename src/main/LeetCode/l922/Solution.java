package main.LeetCode.l922;

public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n=A.length,odd=1,even=0;//第一个奇偶可以存放的位置，指在result中
        int[] result = new int[n];
        int[] target = A;
        for (int i = 0;i<n;i++){
            if(target[i]%2==0){//如果目标数是偶数
                result[even] = target[i];
                even+=2;
            }else{
                result[odd] = target[i];
                odd+=2;
            }
        }
        return result;
    }
}
