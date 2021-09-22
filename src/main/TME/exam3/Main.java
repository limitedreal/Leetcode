package main.TME.exam3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        List<Integer> list = new ArrayList<>();
        long cnt = 0;
        long result = 0;
        list.add(0);
        while (cnt < n) {
            result++;
            cnt += doAdd(list, k);
        }
        System.out.println(result);
    }

    public static long doAdd(List<Integer> list, int k) {
        int index = list.size() - 1;
        boolean flag = true;
        while (index >= 0) {
            Integer item = list.get(index);
            if (item + 1 >= k) {
                list.set(index, 0);
            } else {
                list.set(index, item+1);
                flag = false;
                break;
            }
            index--;
        }
        if (flag) {
            list.add(0, 1);
        }
        long cnt = 0;
        for (Integer integer : list) {
            if (integer == 1) {
                cnt++;
            }
        }
        return cnt;
    }
}
