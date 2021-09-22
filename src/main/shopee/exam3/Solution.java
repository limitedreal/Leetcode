package main.shopee.exam3;

public class Solution {
    public static void main(String[] args) {

        int m = 2;
        int[]weights={100000,100000-1,1,1,1};
        Solution s=new Solution();
        System.out.println(s.Solve(weights.length, m, weights));

    }

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param n       int整型 表示有n个物品
     * @param m       int整型 表示有m个袋子
     * @param weights int整型一维数组 每个物品的重量
     * @return long长整型
     */
    public static int len=0;
    public long Solve(int n, int m, int[] weights) {
        long capacity = 1;
        len=n;
        for(int i=0;i<len;i++){
            capacity = Math.max(capacity, weights[i]);
        }
        while (!check(m, capacity, weights)) {
            capacity++;
        }
        return capacity;
    }
    public boolean check(int m, long capacity, int[] weights) {
        int index=0;
        for (int i = 0; i < m; i++) {
            long c=capacity;
            while (index<len){
                if(c-weights[index]<0){
                    break;
                }
                c-=weights[index];
                index++;
            }
        }
        return index>=len;
    }

    //public boolean check(int m, long capacity, int[] weights) {
    //    //检查capacity容量的m个背包能否能够装下
    //    long preValue = capacity;
    //    for (int weight : weights) {
    //        if (capacity - weight < 0) {
    //            m--;
    //            if (m <= 0) {
    //                return false;
    //            }
    //            capacity = preValue;
    //        }
    //
    //        capacity = capacity - weight;
    //    }
    //    return m >= 0;
    //}
}
/*
* 您的代码已保存
请检查是否存在语法错误或者数组越界、堆栈溢出等非法访问情况
case通过率为0%, 后台判题数据不一定包含示例数据
* */
/*
您的代码已保存
您提交的程序没有通过所有测试用例
case通过率为0%, 后台判题数据不一定包含示例数据
 */