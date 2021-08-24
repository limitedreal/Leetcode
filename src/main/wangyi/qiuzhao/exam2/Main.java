package main.wangyi.qiuzhao.exam2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] split = s1.split(",");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        sc.close();
        StringBuilder s = new StringBuilder("a");
        for (int i = 1; i < n; i++) {
            StringBuilder reverse = invert(s).reverse();
            s.append((char) (i + 'a'));
            s.append(reverse);
        }
        System.out.println(s.charAt(k-1));
    }

    public static StringBuilder invert(StringBuilder sb) {
        StringBuilder s = new StringBuilder(sb);
        for (int i = 0; i < sb.length(); i++) {
            int c = s.charAt(i);
            c = 'z' - c + 'a';
            s.setCharAt(i, (char) c);
        }
        return s;
    }
}
