package main.LeetCode.l401;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.readBinaryWatch(9);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        List<String>[] lists = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < 60; i++) {
            int t = howMuchOne(i);
            if (i < 10) {
                lists[t].add("0" + i);
            } else {
                lists[t].add(String.valueOf(i));
            }
        }
        for (int i = 0; i < 12; i++) {
            int t = howMuchOne(i);
            if (turnedOn - t>=0&&turnedOn-t<=6 ) {

                for (String s : lists[turnedOn - t]) {
                    result.add(i + ":" + s);
                }
            }
        }
        return result;
    }

    public int howMuchOne(int target) {
        //返回target在二进制下有多少个1
        int result = 0;
        while (target != 0) {
            result += target & 1;
            target = target >> 1;
        }
        return result;

    }

}
