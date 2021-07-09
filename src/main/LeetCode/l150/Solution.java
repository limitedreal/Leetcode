package main.LeetCode.l150;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> k = new Stack<>();
        Deque<String> stack = new ArrayDeque(Arrays.asList(tokens));
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())));
                    break;
                }
                case "-": {
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) - Integer.parseInt(stack.pop())));
                    break;
                }
                case "*": {
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop())));
                    break;
                }
                case "/": {
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) / Integer.parseInt(stack.pop())));
                    break;
                }
                default: {
                    stack.push(token);
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
