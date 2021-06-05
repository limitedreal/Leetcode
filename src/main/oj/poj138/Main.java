package main.oj.poj138;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] test = {5,4,3,2,1};
        System.out.println(solution(test));
    }

    static boolean solution(int[] test) {
        Stack<Integer> order = new Stack<Integer>(), simulate = new Stack<Integer>();
        int n = test.length;
        for (int i = n; i > 0; i--) {
            order.push(i);
        }
        int orderNow = order.peek();
        for (int i = 0; i < n; i++) {
            if (test[i] >= orderNow) {
                while (true) {
                    orderNow = order.pop();
                    simulate.push(orderNow);
                    if (test[i] == orderNow) {
                        break;
                    }
                }
            }
            if (test[i] != simulate.pop()) {
                return false;
            }
        }
        return true;
    }
}
