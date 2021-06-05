package main.LeetCode.l17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        letterCombinations("27");
        //int num = (int)ch - (int)('0');
    }
    public static List<String> letterCombinations(String digits) {
        char [] target = digits.toCharArray();
        int n = target.length;
        if(n==0){
            return new ArrayList<>();
        }
        List<List<Character>> charList = new ArrayList<>();
        for ( char i : target){
            charList.add(getChar(i));
        }
        int[] guide = new int[n];
        List<String > result = new ArrayList<>();
        while (true){
            result.add(getTargetString(charList,guide));
            guide[n-1]++;
            int i = n-1;
            while(guide[i]>charList.get(i).size()-1){//这个2有问题，大家不一定是3个滴
                guide[i] = 0;
                i--;
                if(i<0){
                    return result;
                }
                guide[i]++;
            }
        }
    }

    public static String getTargetString(List<List<Character>> charList,int[] guide){
        int n = guide.length;
        char[] result = new char[n];
        for (int i=0;i<n;i++){
            result[i] = charList.get(i).get(guide[i]);
        }
        return new String(result);
    }

    public static List<Character> getChar(char c) {
        switch(c) {
            case '2': return Arrays.asList('a', 'b', 'c');
            case '3': return Arrays.asList('d', 'e', 'f');
            case '4': return Arrays.asList('g', 'h', 'i');
            case '5': return Arrays.asList('j', 'k', 'l');
            case '6': return Arrays.asList('m', 'n', 'o');
            case '7': return Arrays.asList('p', 'q', 'r', 's');
            case '8': return Arrays.asList('t', 'u', 'v');
            case '9': return Arrays.asList('w', 'x', 'y', 'z');
            default : return new ArrayList();
        }
    }
}
