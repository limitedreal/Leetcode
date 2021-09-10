package main.xiaohongshu.exam2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    /* Write Code Here */
    Set<String> set = new HashSet<>();

    public int partitionNumber(String text) {
        //段式回文看似唬人，但是一个段式回文实际上只需要首位字母就够了
        //但是分割的方法仍然很复杂
        //做做试试，nmd，不会没hc了就刁难起来了⑧
        //回溯试试，深度优先yyds
        int divide = divide(text, 0,"",0);
        return set.size();
    }

    public int divide(String str, int n, String now, int insert) {
        int m = str.length();
        if ("".equals(str)) {
            set.add(now);
        }

        //是不是要m/2?因为至少分一段
        for (int i = 0; i < m / 2; i++) {
            if (str.substring(0, i + 1).equals(str.substring(m - i - 1, m))) {
                //这个地方应该不行吧，如果是"aaatoaaa"，那a和a递归Lee aa和aa却没有
                StringBuilder sb = new StringBuilder(now);
                sb.insert(insert, "," + str.substring(0, i + 1)
                        + "," + str.substring(0, i + 1) + ",");
                divide(str.substring(i + 1, m - i - 1), n + 2, sb.toString(), insert+1+ str.substring(0, i + 1).length());
            }
        }
        return n;
    }
}

public class Main {
    public static void main(String[] args) {
        String x = "gotogo";

        int res = new Solution().partitionNumber(x);
        System.out.println(String.valueOf(res));

    }
}
