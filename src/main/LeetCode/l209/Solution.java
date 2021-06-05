package main.LeetCode.l209;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public static void main(String[] args) {
        int[] k = {1, 4, 4};
        System.out.println(minSubArrayLen(7, k));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, result = Integer.MAX_VALUE;
        int low = 0, high = 0;
        int sum = nums[low];
        while (low <= high) {
            if (sum < target) {
                high++;
                if (high >= nums.length) {
                    break;
                }
                sum += nums[high];
            } else if (sum >= target) {
                //可能这里存在着low>high的情况，这个时候说明有一个元素本身比target大，那么最短子数组长度必然为1
                result = Math.min(result, high - low + 1);
                sum -= nums[low];
                low++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    //动态规划
    //public static int minSubArrayLen(int target, int[] nums) {
    //    //动态规划
    //    int n = nums.length;
    //    int result = Integer.MAX_VALUE;
    //    int []dynamic = new int[n];
    //    for (int i = 0;i<n;i++){
    //        dynamic[i] = nums[i];
    //        for (int j = i+1;j<n;j++){
    //            dynamic[j] = dynamic[j-1]+nums[j];
    //            if(dynamic[j]>=target){
    //                result=Math.min(result,j-i+1);
    //            }
    //        }
    //    }
    //    return result;
    //}
}
//leetcode submit region end(Prohibit modification and deletion)

