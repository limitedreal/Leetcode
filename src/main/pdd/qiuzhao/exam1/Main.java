package main.pdd.qiuzhao.exam1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            List<Pro> list = new ArrayList<>(n + 1);
            for (int i = 0; i < n; i++) {
                int score = sc.nextInt();
                int day = sc.nextInt();
                list.add(new Pro(score, day));
            }
            list.sort((o1, o2) -> {
                return o2.score - o1.score;
            });
            int score = digui(list, 0, 1);
            System.out.println(score);
        }
    }

    public static int digui(List<Pro> preList, int score, int day) {
        int n = preList.size();
        int result = score;
        for (int i = 0; i < n; i++) {
            List<Pro> list = new LinkedList<>(preList);
            Pro pro = list.get(i);
            list.remove(i);
            if (pro.day >= day) {
                int t = digui(list, score + pro.score, day + 1);
                result = Math.max(result, t);
            }
        }
        return result;
    }
}

class Pro {
    int score;
    int day;

    public Pro(int score, int day) {
        this.score = score;
        this.day = day;
    }
}
