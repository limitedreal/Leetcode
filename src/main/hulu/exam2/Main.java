package main.hulu.exam2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long result = 0;
        int[] nums = new int[n];
        int sum=0;
        for (; a <= b; a++) {
            String s = String.valueOf(a);
            sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }
            if (sum % n == 0) {
                for (int i = 0; i < s.length(); i++) {
                    nums[i] = s.charAt(i) - '0';
                }
                result++;
                break;
            }
        }
        //下面采用新方法
        sum=0;
        for (; a <= b; a++) {
            sum+=add(nums);
            if(sum==n){
                result++;
                sum=0;
            }
        }
        System.out.println(result);
    }

    public static int add(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            a[i]++;
            result++;
            if (a[i] < 10) {
                return result;
            } else {
                a[i] = 0;
                result -= 10;
            }
        }
        return result;
    }
}
