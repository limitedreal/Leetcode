//package main.xiaohongshu.qiuzhao.exam3;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Main {
//    static int result;
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        //dfs
//        int n = sc.nextInt();
//        int[] arr=new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i]=sc.nextInt();
//        }
//        result=0;
//        dfs(arr);
//        System.out.println(result);
//
//    }
//    public static void dfs(int[]arr){
//        //我们对这个数组进行切片
//        int start=0;
//        for(int end=4;end<arr.length;end++){
//            boolean check = check(arr, start, end);
//            if(check){
//                result++;
//                start=end+1;
//                end++;
//            }
//        }
//    }
//    public static boolean check(int[]arr,int start,int end){
//        //对于每一个序列，我们要选取两个元素的组合，判断他们能不能组成对应的模式
//        List<Integer> list=new ArrayList<>(arr);
//        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
//        for (int i = 0; i < collect.size(); i++) {
//            Integer i1=collect.get(i);
//            for (int j = i+1; j < collect.size(); j++) {
//                Integer i2=collect.get(j);
//                for (int k = 0; k < arr.length; k++) {
//                    if(list.stream().filter((o)->{
//                        return o==i1;
//                    }).count()==4||list.stream().filter((o)->{
//                        return o==i2;
//                    }).count()==4){
//                        return true;
//                    }
//
//                }
//            }
//        }
//    }
//    public static boolean check(int[]arr,int index){
//        Map<Integer,Character> map=new HashMap<>();
//        char c='A';
//        StringBuilder sb=new StringBuilder();
//        for (int i = 0; i < 4; i++) {
//            if(map.containsKey(arr[i])){
//                sb.append(map.get(arr[i]));
//            }else{
//                if(c=='C'){
//                    return false;
//                }else{
//                    map.put(arr[i],c);
//                    sb.append(c);
//                    c= (char) (c+1);
//                }
//            }
//        }
//        switch (sb.toString()){
//            case "AABB":{
//                return true;
//            }
//            case "ABAB":{
//                return true;
//            }
//            case "ABBA":{
//                return true;
//            }
//            case "AAAA":{
//                return true;
//            }
//        }
//        return false;
//    }
//}
