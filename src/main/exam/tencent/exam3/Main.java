package main.exam.tencent.exam3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            Integer[] arr = new Integer[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            list.add(arr);
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int p = sc.nextInt();
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int j = 0; j < p; j++) {
                //接收数组下标
                int index = sc.nextInt()-1;
                //此处的index从1开始所以需要-1
                Integer[] arr = list.get(index);
                for (Integer item : arr) {
                    queue.add(item);
                }
            }
            int k = sc.nextInt();
            Integer result = 0;
            for (int j = 0;j<k;j++){
                result = queue.poll();
            }
            System.out.println(result);

        }
    }
}


