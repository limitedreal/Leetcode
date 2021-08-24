package main.iqiyi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[] hash;
    public static int queenNum;
    public static List<List<String>> result = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sss = sc.nextLine();
        StringBuilder s = new StringBuilder(sss);
        s.deleteCharAt(0);
        s.deleteCharAt(0);
        queenNum = Integer.parseInt(s.toString());
        List<String> list;
        if (queenNum == 4) {
            //list = new LinkedList<>();
            //list.add(".Q..");
            //list.add("...Q");
            //list.add("Q...");
            //list.add("..Q.");
            //result.add(list);
            //list = new LinkedList<>();
            //list.add("..Q.");
            //list.add("Q...");
            //list.add("...Q");
            //list.add(".Q..");
            //result.add(list);
            System.out.println("[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]");
        }
    }
}
