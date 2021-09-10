package main.tencent.exam5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[]a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                boolean check = check(a, i, j);
                if(check){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static boolean check(int[]arr,int start,int end){
        for (int i=start+1;i<end;i++){
            if(arr[i]<arr[start]||arr[i]<arr[end]){
                return false;
            }
        }
        return true;
    }
}
