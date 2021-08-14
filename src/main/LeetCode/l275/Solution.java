package main.LeetCode.l275;

public class Solution {
    public static void main(String[] args) {
        //Integer.MAX_VALUE;
        System.out.println(((0x7fffffff-4) + (0x7fffffff-2) >> 1)==0x7fffffff-3);
    }
    public int hIndex(int[] citations) {
        int low=0,high=citations.length-1;
        while (low<high){
            int middle=low+(high-low)/2;
            if(citations[middle]>=citations.length-middle){
                high=middle;
            }else  {
                low=middle+1;
            }
        }
        return citations[high] >= citations.length - high ? citations.length - high : 0;
    }
}
