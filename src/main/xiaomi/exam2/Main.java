package main.xiaomi.exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int x=1;
        int i=0;
        while (list.size()!=1){
            if(x==3){
                list.remove(i);
                x=0;
                i--;
            }
            i++;
            i=i%list.size();
            x++;
        }
        System.out.println(list.get(0));
    }
}
