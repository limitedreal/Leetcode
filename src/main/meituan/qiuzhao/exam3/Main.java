package main.meituan.qiuzhao.exam3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer, Song> map = new HashMap<>();
        Song d=new Song(0,0,0,0);
        int total=0;
        for (int i = 0; i < n; i++) {
            int happy = sc.nextInt();
            int removeHappy = sc.nextInt();
            int series = sc.nextInt();
            int numSeries = sc.nextInt();
            Song s = new Song(happy, removeHappy, series, numSeries);
            //接下来判断移除它值不值得
            Song pre = map.getOrDefault(series, d);
            if(s.numSeries!=pre.numSeries+1){
                happy-=removeHappy;
                total += Math.max(happy, -k);
            }else{
                //这种情况下是不可能需要移除的
                map.put(series,s);
                total+=happy;
            }
        }
        System.out.println(total);
    }
}

class Song {
    int happy;
    int removeHappy;
    int series;
    int numSeries;

    public Song(int happy, int removeHappy, int c, int d) {
        this.happy = happy;
        this.removeHappy = removeHappy;
        this.series = c;
        this.numSeries = d;
    }
}