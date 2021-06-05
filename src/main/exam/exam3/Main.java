package main.exam.exam3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Map<Integer, Integer> map = new HashMap<>();
        boolean repeat = false;
        for (int i = 0; i < n - k + 1; i++) {
            if (!repeat) {
                for (int j = 0; j < k; j++) {
                    //arr[i+j]中的众数
                    int temp = arr[i + j];
                    if (map.containsKey(temp)) {//如果已经包含
                        int f = map.get(temp);
                        map.put(temp, f + 1);
                    } else {
                        map.put(temp, 1);
                    }
                }
                repeat = true;
            } else {
                Integer temp = arr[i - 1];
                map.put(temp, map.get(arr[i - 1]) - 1);
                //获取新的一个
                temp = arr[i + k - 1];
                if (map.containsKey(temp)) {//如果已经包含
                    int f = map.get(temp);
                    map.put(temp, f + 1);
                } else {
                    map.put(temp, 1);
                }
            }

            int frequency = 0;
            int result = 0;
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                Integer key = entry.getKey();
                Integer f = entry.getValue();
                if (f == frequency) {
                    if (key < result) {
                        result = key;
                    }
                }
                if (f > frequency) {
                    frequency = f;
                    result = key;
                }
            }
            System.out.println(result);
        }
    }

    /**
     * 用Collections.sort(List)排序
     * list元素的类型是String类型
     * String 类型实现了Commparable接口,并重写了CompareTo方法
     * CompareTo方法中写的是比较原则
     */
    public void sortString() {
        ArrayList<String> strs = new ArrayList<String>();
        strs.add("123");
        strs.add("987");
        strs.add("abc");
        strs.add("ABC");

        System.out.println("---------------原始顺序,没有排序-------------");
        for (String str : strs) {
            System.out.println(str);
        }
        System.out.println("----------------------------------------");
        Collections.sort(strs);
        System.out.println("--------------- 经过排序后输出   --------------");
        for (String str : strs) {
            System.out.println(str);
        }

    }
}

