package main.exam.ali.exam1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] arr = new int[t][3];
        for (int i = 0; i < t; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < t; i++) {
            int reverseCount = 0;
            int a = arr[i][0], b = arr[i][1], c = arr[i][2];
            LinkedList<Integer> aBinary = new LinkedList<Integer>(), bBinary = new LinkedList<Integer>(),cBinary = new LinkedList<Integer>();
            while (a!=0||b!=0||c!=0) {
                aBinary.add(a % 2);
                a/=2;
                bBinary.add(b % 2);
                b/=2;
                cBinary.add(c % 2);
                c/=2;
            }
            for (int j = 0;j<aBinary.size();j++){
                int aBit = aBinary.get(j);
                int bBit = bBinary.get(j);
                int cBit = cBinary.get(j);
                if(cBit==0){
                    if(aBit!=0){
                        aBinary.set(j,0);
                        reverseCount++;
                    }
                    if(bBit!=0){
                        reverseCount++;
                    }
                }
                if(cBit==1){
                    if(aBit==0&&bBit==0){

                    }
                }
                
            }

        }


    }

}
