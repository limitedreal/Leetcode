package main;

public class Baidu {
    public static void main(String[] args) {

    }

    //包括正负号、整数小数、科学计数法
    // 有限自动机
    //        //
    //        /**0
    //         * +   1 5
    //         * -   1 5
    //         * .    2
    //         * [0-9]  1
    //         * e    3 4
    //         */

    public static boolean isNum(String str){
        return isInteger(str.toCharArray(),0);
    }

    public static boolean isInteger(char[] chars,int start) {
        boolean flag = false;
        if (chars[start] == '+' || chars[start] == '-') {
            start++;
        }
        for (int i=start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                //是不是小数
                if (chars[i] == '.') {
                    return isFlout(chars, i);
                } else if (chars[i] == 'e' || chars[i] == 'E') {
                    //是不是整数科学计数法
                    return isScience(chars, i);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isFlout(char[] chars, int start) {
        //跳过小数点
        start++;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                if (chars[i] == 'e' || chars[i] == 'E') {
                    return isScience(chars, i);
                } else {
                    return false;
                }
            }
        }
        return true;
        //e
    }

    private static boolean isScience(char[] chars, int start) {
        //跳过e
        start++;
        if (start < chars.length) {
            if (chars[start] == '+' || chars[start] == '-') {
                start++;
            }
        }
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return false;
            }
        }
        return true;
    }
}
