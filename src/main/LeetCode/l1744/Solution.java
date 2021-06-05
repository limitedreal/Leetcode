package main.LeetCode.l1744;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] k={{56, 446, 26}};
        int[] candy = {10,11,42,42,49,14,44,33,13,49,32,19,48,36,25,38,32,45,30,21,13,45,39,12,12,25,26,18,35,28,1,31,14,16,38,49,26,33,39,39,7,31,20,8,49,36,6,1,32,2,35,10,31,37,13,43,26};
        s.canEat(candy,k);
        }
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length;
        boolean[] result = new boolean[n];
        //注意，按照题的意思其实queries【i】和queries【j】的方案选择是无关的
        for (int i = 0; i < n; i++) {
            int type = queries[i][0], day = queries[i][1], cap = queries[i][2];
            double preSum = 0;
            for (int j = 0; j < type; j++) {
                preSum += candiesCount[j];
            }
            if (preSum == 0) {
                result[i] = true;
            }
            if (cap * (day + 1) > preSum) {//这样才能吃到这一天，说明糖果不太多
                if((preSum+candiesCount[type])>day){//至少保证每天有糖吃
                    result[i] = true;
                }
            }
        }
        return result;
    }
}
