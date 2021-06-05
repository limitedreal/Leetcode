package main.wangyi.exam1;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[]x={5,10,10,10,20};
        System.out.println(s.billsChange(x));
    }
    public int billsChange (int[] bills) {
        int[] money = new int[2];
        money[0] = 2;
        for (int i = 0;i<bills.length;i++){
            if(bills[i]==5){
                money[0]++;
            }
            if(bills[i]==10){
                money[0]--;
                if(money[0]<0){
                    return i;
                }
                money[1]++;
            }
            if(bills[i]==20){
                if(money[1]>0){//如果有10块就给10块
                    money[1]--;
                    money[0]--;
                    if(money[0]<0){
                        return i;
                    }
                }else{//没有10块就要给3个5块
                    money[0]-=3;
                    if(money[0]<0){
                        return i;
                    }
                }
            }
        }
        return bills.length;
    }
}
