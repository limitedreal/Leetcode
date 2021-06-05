package main.duxiaoman;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] books = new int[n][6];
            for (int j = 0; j < n; j++) {
                books[j][0] = sc.nextInt();
                books[j][1] = sc.nextInt();
                books[j][2] = sc.nextInt();
                books[j][3] = sc.nextInt();
                books[j][4] = sc.nextInt();
                books[j][5] = j;
            }
            int[][] s = mySort(books);//s[i][0]表示第一个维度排名第i位的是哪本书
            int[] q = new int[n];
            for (int j = 0; j < n; j++) {
                //开始寻找
                q[s[j][0]]++;
                q[s[j][1]]++;
                q[s[j][2]]++;
                q[s[j][3]]++;
                q[s[j][4]]++;
                //下面在q中寻找最先满5个的两本书
                int m1 = 0, m2 = 0;
                for (int k = 0; k < n; k++) {
                    if (q[k] > q[m1]) {
                        m1 = k;
                    }
                }
                for (int k = 0; k < n; k++) {
                    if (q[k] > q[m2] && k != m1) {
                        m2 = k;
                    }
                }
                if (q[m1] + q[m2] >= 5) {
                    int[] c = new int[5];
                    for (int k = 0; k < 5; k++) {
                        c[i] = books[m1][i] > books[m2][i] ? books[m1][i] : books[m2][i];
                    }
                    int m3 = 0;
                    for (int k = 0; k < 5; k++) {
                        if (c[i] > c[m3]) {
                            m3 = i;
                        }
                    }
                    System.out.println(c[m3] + " " + books[m1][6] + " " + books[m2][6]);
                    break;
                }
            }
        }


    }

    public static int[][] mySort(int[][] x) {
        int n = x.length;
        int[][] s = new int[n][5];//n本书5个维度的
        int[][] books = x;
        //1
        Arrays.sort(x, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? 1 : -1;
            }
        });
        for (int j = 0; j < n; j++) {
            s[j][0] = books[j][5];
        }
        //2
        Arrays.sort(x, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });
        for (int j = 0; j < n; j++) {
            s[j][1] = books[j][5];
        }
        //3
        Arrays.sort(x, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[2] > o2[2] ? 1 : -1;
            }
        });
        for (int j = 0; j < n; j++) {
            s[j][2] = books[j][5];
        }
        //4
        Arrays.sort(x, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[3] > o2[3] ? 1 : -1;
            }
        });
        for (int j = 0; j < n; j++) {
            s[j][3] = books[j][5];
        }
        //5
        Arrays.sort(x, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[4] > o2[4] ? 1 : -1;
            }
        });
        for (int j = 0; j < n; j++) {
            s[j][4] = books[j][5];
        }
        return s;
    }
}