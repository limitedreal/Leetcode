package main.LeetCode.l415;

public class Solution {

    public static void main(String[] args) {
        System.out.println(100%1.0);
    }

    public String addStrings(String num1, String num2) {
        if (num1.length() > num2.length()) {
            num2 = addZero(num2, num1.length());
        } else {
            num1 = addZero(num1, num2.length());
        }
        StringBuilder sb = new StringBuilder(num1.length() + 1);
        boolean carry = false;
        for (int i = 0; i < num1.length(); i++) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(i) - '0';
            int add = n1 + n2;
            if (carry) {
                add++;
            }
            if (add >= 10) {
                carry = true;
                add -= 10;
            } else {
                carry = false;
            }
            sb.append(add);
        }
        if (carry) {
            sb.append(1);
        }
        StringBuilder reverse = sb.reverse();
        return reverse.toString();
    }

    public String addZero(String str, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length - str.length(); i++) {
            sb.append(0);
        }
        sb.append(str);
        return sb.toString();
    }
}
