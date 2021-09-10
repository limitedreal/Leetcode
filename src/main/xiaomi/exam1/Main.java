package main.xiaomi.exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s=sc.nextLine();
        String[] split = s.split(",");
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            Integer x=Integer.parseInt(split[i]);
            list.add(x);
        }
        s=sc.nextLine();
        split=s.split(",");
        for (int i = 0; i < split.length; i++) {
            Integer x=Integer.parseInt(split[i]);
            list.add(x);
        }
        list.sort(Integer::compareTo);
        for (Integer item : list) {
            System.out.print(item+" ");
        }
    }
}
