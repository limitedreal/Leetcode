package main.hulu.exam1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int n = chars.length;
        int cnt = 0;
        Map<Integer, List<Character>> map = new HashMap<>(n + 1);
        Map<Integer, List<Character>> newMap = new HashMap<>(n + 1);
        for (int i = 0; i < n; i++) {
            if (chars[i] == '.') {
                System.out.print('.');
                continue;
            }
            System.out.print('X');
            cnt++;
            List<Character> list = map.getOrDefault(i, new LinkedList<>());
            list.add(chars[i]);
            map.put(i, list);
        }
        System.out.println();
        while (cnt != 0) {
            Set<Map.Entry<Integer, List<Character>>> entries = map.entrySet();
            Arrays.fill(chars, '.');
            for (Map.Entry<Integer, List<Character>> entry : entries) {
                List<Character> value = entry.getValue();
                for (Character c : value) {
                    int index = entry.getKey();
                    if (c == 'R') {
                        index += v;
                        if (index < n) {
                            List<Character> list = newMap.getOrDefault(index, new LinkedList<>());
                            list.add(c);
                            chars[index] = 'X';
                            newMap.put(index,list);
                        } else {
                            cnt--;
                        }
                    } else {
                        index -= v;
                        if (index >= 0) {
                            List<Character> list = newMap.getOrDefault(index, new LinkedList<>());
                            list.add(c);
                            chars[index] = 'X';
                            newMap.put(index,list);
                        } else {
                            cnt--;
                        }
                    }
                }
            }
            Map<Integer, List<Character>> t = map;
            map = newMap;
            newMap = t;
            newMap.clear();
            System.out.println(new String(chars));
        }
    }
}
