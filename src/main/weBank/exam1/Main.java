package main.weBank.exam1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        int max = -1,count = 0;
        for (int i = 0;i<n;i++){
            h[i] = sc.nextInt();
            if(h[i]>max){
                max = h[i];
                count = 1;
            }else if(h[i]==max){
                count++;
            }
        }
        System.out.println(count);

    }
}
