package main.LeetCode.l15;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //List<Integer> list = new ArrayList<>();
        //list.add(sc.nextInt());
        //int n = list.size();
        //int[] nums = new int [n];
        //for (int i = 0;i<n;i++){
        //    nums[i] = list.get(i);
        //}
        int[] nums = {0,0,0};
        int i = 0, j = 1, k = 2;
        String temp = nums[i] + "," + nums[j] + "," + nums[k];
        String temp2 = nums[i] + "," + nums[j] + "," + nums[k];
        Set<String> set = new HashSet<>();
        set.add(temp);
        System.out.println(set.contains(temp2));
        System.out.println(set);

        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<String> repetition = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int key : nums) {
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }

        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {//最后两个就不用加入遍历了，顺便保证下面的不会越界
            //剪枝
            if (nums[i] + nums[n - 1] + nums[n - 2] < 0) {//说明这个数太小了，根本不可能找得到
                continue;
            }
            if (nums[i] > 0) {
                break;
            }

            for (int j = i + 1; j < n - 1; j++) {
                //剪枝
                if (nums[i] + nums[j] + nums[n - 1] < 0) {
                    continue;
                }
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                int k = -(nums[i] + nums[j]);
                if(map.containsKey(k)){//说明存在这种情况
                    if(k<nums[i]||k<nums[j]){
                        continue;
                    }
                    int count = map.get(k);
                    if(nums[i]==k){
                        count--;
                    }
                    if(nums[j]==k){
                        count--;
                    }
                    if(count<=0){
                        continue;
                    }
                    String test = nums[i] + "," + nums[j] + "," + k;
                    if (repetition.contains(test)) {//如果存在，就可以跳过了
                        continue;
                    }
                    repetition.add(test);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(k);

                    result.add(temp);
                }
            }
        }
        return result;
    }
}
