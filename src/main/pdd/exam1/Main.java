package main.pdd.exam1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = dfs(a, new LinkedList<Integer>(), 0, true);
        System.out.println(k);
    }

    public static int dfs(int[] a, List<Integer> pre, int now, boolean upper) {
        //每次递归包含两部分，选他和不选他
        //选他分为两部分，
        List<Integer> list = new LinkedList<>(pre);
        if (list.size() == 5) {
            int k = 0;
        }
        if (now == a.length) {
            if (list.size() < 3) {
                return 0;
            }
            if (upper) {//如果还没开始减少
                return 0;
            }
            if (list.get(0) > list.get(1)) {//如果一开始就在下降
                return 0;
            }
            return list.size();
        }

        if (list.size() == 0) {//保证pre中至少有一个元素
            int n1 = dfs(a, list, now + 1, upper);
            list.add(a[now]);
            int n2 = dfs(a, list, now + 1, upper);
            return max(n1, n2);
        }
        if (upper) {//如果还在上升的话
            int n1 = dfs(a, list, now + 1, upper);//不选他
            //选他
            int t = list.get(list.size() - 1);
            int n2 = 0;
            list.add(a[now]);
            if (a[now] > t) {
                int k = dfs(a, list, now + 1, upper);
                n2 = max(n2, k);
            } else {
                int k = dfs(a, list, now + 1, false);
                n2 = max(n2, k);
            }
            return max(n1, n2);

        } else {//已经开始下降了,但是尖峰数组同样不能一开始就下降
            int n1 = dfs(a, list, now + 1, upper);
            int t = list.get(list.size() - 1);
            int n2 = 0;
            list.add(a[now]);
            if (a[now] < t) {
                int k = dfs(a, list, now + 1, upper);
                n2 = max(n2, k);
            }
            return max(n1, n2);
        }

    }
}
