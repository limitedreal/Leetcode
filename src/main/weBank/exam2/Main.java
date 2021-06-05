package main.weBank.exam2;

import java.util.*;

public class Main {
    //public static void main(String[] args) {
    //    Map<Integer,List<Integer>> map = new HashMap<>();
    //    System.out.println(map.get(5)==null);
    //}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        double[] pool = new double[n];
        //并查集法
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            pool[i] = sc.nextInt();
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            if (arr[a] == a && arr[b] == b) {
                arr[b] = arr[a];
            } else if (arr[a] != a && arr[b] == b) {
                arr[b] = arr[a];
            } else if (arr[a] == a && arr[b] != b) {
                arr[a] = arr[b];
            } else {
                int t1 = findRootIndex(a, arr), t2 = findRootIndex(b, arr);
                arr[t2] = arr[t1];
            }
        }
        //这里要进行一次统一root

        for (int i = 0; i < n; i++) {
            findRootIndex(i,arr);
        }
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == i) {//找到了一个并查集的root
                double total = 0, count = 0;
                for (int j = 0;j<n;j++){
                    if(arr[j]==i){
                        total+=pool[j];
                        count++;
                    }
                }
                double aver = total/count;
                for (int j = 0;j<n;j++){
                    if(arr[j]==i){
                        result[j] = aver;
                    }
                }
            }
        }
        for (double item : result) {
            System.out.printf("%.2f ",item);
        }
    }

    public static int findRootIndex(int now, int[] arr) {
        if (arr[now] != now) {
            arr[now] = findRootIndex(arr[now], arr);
        }
        return arr[now];
    }


    public static void method1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        double[] pool = new double[n];
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            pool[i] = sc.nextInt();
        }
        List<List<Integer>> lists = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            List<Integer> lista = map.get(a), listb = map.get(b);
            if (lista == null && listb == null) {
                List<Integer> list = new LinkedList<>();
                list.add(a);
                list.add(b);
                lists.add(list);
                map.put(a, list);
                map.put(b, list);
            } else if (lista != null && listb != null) {
                //两个都不为null，就意味着在两个不同的链表中
                //把b合并到a中
                lists.remove(listb);
                lista.addAll(listb);
                for (Integer item : listb) {
                    map.put(item, lista);
                }
            } else {//一个在，一个不在
                if (lista == null) {
                    //如果是a不在
                    listb.add(a);
                    map.put(a, listb);
                } else {
                    lista.add(b);
                    map.put(b, lista);
                }
            }
        }
        for (List<Integer> list : lists) {
            double length = list.size(), count = 0;
            for (Integer item : list) {
                count += pool[item];
            }
            for (Integer item : list) {
                pool[item] = count / length;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f ", pool[i]);
        }
    }

}
