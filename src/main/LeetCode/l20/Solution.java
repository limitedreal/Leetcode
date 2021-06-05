package main.LeetCode.l20;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            char temp;
            try {
                switch (now) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(now);
                        break;

                    case ')': {
                        temp = stack.pop();
                        if (temp != '(') {
                            return false;
                        }
                        break;
                    }
                    case ']':
                        temp = stack.pop();
                        if (temp != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        temp = stack.pop();
                        if (temp != '{') {
                            return false;
                        }
                        break;
                    default:
                }
            }catch (Exception e){
                return false;
            }

        }

        return stack.empty();
    }
}
