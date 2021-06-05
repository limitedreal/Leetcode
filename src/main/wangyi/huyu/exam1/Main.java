package main.wangyi.huyu.exam1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] sql = new String[n][2];
        for (int i = 0; i < n; i++) {
            sql[i][0] = sc.next();
            sql[i][1] = sc.next();
        }
        //group by就用List<List<>>实现了
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0;i<n;i++){
            String id=sql[i][0];
            String name = sql[i][1];
            if(!map.containsKey(name)){//如果不包含这个key
                map.put(name,new LinkedList<>());
            }
            map.get(name).add(id);
        }
        int count=0;
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            List<String> list = entry.getValue();
            if(list.size()>=2){
                count++;
            }
        }
        System.out.println(count);
    }
}
