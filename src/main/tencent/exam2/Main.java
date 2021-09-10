package main.tencent.exam2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            a[i] = cal(a[i]);
        }
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            b[i] = cal(b[i]);
        }
        sc.close();
        Arrays.sort(a,Collections.reverseOrder());
        Arrays.sort(b,Collections.reverseOrder());
        Deque<Integer> ad=new LinkedList(Arrays.asList(a));
        Deque<Integer> bd=new LinkedList(Arrays.asList(b));
        int cnt=0;
        while (!ad.isEmpty()&&!bd.isEmpty()){
            Integer ah = ad.peek();
            Integer bh = bd.poll();
            if(ah<=bh){
                ad.pollLast();
            }else{
                ad.poll();
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static int cal(int n) {
        //计算n的因子数量
        int sqrt = (int) Math.sqrt(n);
        int cnt = 0;
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                cnt += 2;
            }
        }
        if (n ==sqrt*sqrt) {
            cnt--;
        }
        return cnt;
    }
}
