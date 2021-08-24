package main.wangyi.qiuzhao.exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        int m = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        int n = list.size();
        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j=i+1;j<n;j++){
                if(list.get(i)+list.get(j)<=m){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }

    //public int binarySearch() {
    //
    //}
}
