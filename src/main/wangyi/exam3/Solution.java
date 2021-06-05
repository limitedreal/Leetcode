package main.wangyi.exam3;

public class Solution {
    public static void main(String[] args) {
        int[]e = {2,3,4},c={3,4,3};
        Solution s = new Solution();
        System.out.println(s.canCompleteRace(e, c));
    }

    public int canCompleteRace (int[] e, int[] c) {
        for (int i = 0;i<e.length;i++){
            if(dfs(e,c,i,i,0)){
                return i;
            }
        }
        return -1;
    }
    public boolean dfs(int[]e,int[]c,int start,int now,int remain){
        remain+=e[now]-c[now];
        if(remain<0){
            return false;
        }
        if((now+1)%e.length==start){
            return true;
        }
        return dfs(e,c,start,(now+1)%e.length, remain);
    }
}
