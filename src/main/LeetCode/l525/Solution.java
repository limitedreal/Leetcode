package main.LeetCode.l525;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,1,1,0,0,0};
        System.out.println(s.findMaxLength(nums));
    }
    public int findMaxLength(int[] nums) {
        //最好的方法仍然是前缀和+map
        //但是由于0加不加对于和来说没有影响，这个元素的作用是被隐藏的
        //所以我们将0转化为-1，使其有效果
        int n = nums.length;
        for (int i = 0;i<n;i++){
            nums[i]=nums[i]==0?-1:nums[i];
        }
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0;i<n;i++){
            sum+=nums[i];
            if(sum==0){
                result=Math.max(result,i+1);
            }
            if(!map.containsKey(sum)){//如果还没有，就先放进去
                map.put(sum,i);
            }
            if(map.containsKey(sum)){
                int t = map.get(sum);
                result=Math.max(result,i-t);
            }
        }
        return result;
    }
}
