package main.LeetCode.l10;

public class Solution {
    public static void main(String[] args) {
        String s = "aab", p = "c*a*b";
        String substring = p.substring(2);

        isMatch(s, p);
    }

    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (s.length() == 0 || p.length() == 0) {
            return false;
        }
        //由于*的特殊性，现在我们应该先以*为分隔符将字符串拆开
        String[] split = p.split("[*]");

        for (int i = 0; i < split.length; i++) {
            String match = split[i];
            while (s.startsWith(match)) {
                s = s.substring(match.length());
            }

        }
        return true;
    }
    //public String getPre(){//这个函数是为了得到*前的前缀的，返回前缀的
    //
    //}
}
