package main.LeetCode.l1122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        relativeSortArray(arr1,arr2);
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n1=arr1.length,n2=arr2.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i :arr1){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        int[]resultPre = new int[n1];
        int index = 0;
        for (int i=0;i<n2;i++){
            int count = map.get(arr2[i]);
            for (int j=0;j<count;j++,index++){
                resultPre[index] = arr2[i];
            }
            map.put(arr2[i],0);
        }
        int truncation = index;//在此截断
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++, index++) {
                resultPre[index] = key;
            }
        }
        Arrays.sort(resultPre,truncation,index);
        return resultPre;
    }
}
