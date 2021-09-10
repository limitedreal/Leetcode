package main.tencent.exam4;

import java.util.*;

public class Main {
    //public static List<Integer> list;
    //public static Map<Integer, String> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        //list = new LinkedList<>();
        //map = new HashMap<>();
        String merge = merge(n);
        int cnt = 0;
        l--;
        r--;
        for (int i = l; i <= r; i++) {
            if (i < merge.length()) {
                char c = merge.charAt(i);
                if (c == '1') {
                    cnt++;
                }
            }else{
                break;
            }
        }
        System.out.println(cnt);
    }

    //分治
    public static String merge(int n) {
        if (n == 1) {
            return "1";
        }
        if(n==0){
            return "0";
        }
        //if (map.containsKey(n)) {
        //    return map.get(n);
        //}
        String merge = merge(n / 2);
        if (n % 2 == 0) {
            merge = merge + "0" + merge;
        } else {
            merge = merge + "1" + merge;
        }
        //map.put(n, merge);
        return merge;
    }


}


//public static void main(String[] args) {
//    List<Integer> list = new ArrayList<>();
//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    int l = sc.nextInt();
//    int r = sc.nextInt();
//    list.add(n);
//    int start = 0;
//    while (start < list.size()) {
//        Integer i = list.get(start);
//        if (i > 1) {
//            list.remove(i);
//            list.add(start, i / 2);
//            list.add(start, i % 2);
//            list.add(start, i / 2);
//        } else {
//            start++;
//        }
//    }
//    int cnt = 0;
//    l--;
//    r--;
//    for (int i = l; i <= r; i++) {
//        if (i < list.size()) {
//            Integer integer = list.get(i);
//            if (integer == 1) {
//                cnt++;
//            }
//        }
//    }
//    System.out.println(cnt);
//}
