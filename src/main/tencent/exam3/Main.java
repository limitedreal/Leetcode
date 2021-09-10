package main.tencent.exam3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();
        int max = sum(str);

    }

    public static int sum(String str) {
        int[] val = new int[str.length()];
        val[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                val[i] = 1;
            } else {
                val[i] = val[i - 1] + 1;
            }
        }
        return Arrays.stream(val).sum();
    }
}
