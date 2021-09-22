package main.xiaohongshu.qiuzhao.exam1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        boolean[][] matrix = new boolean[r][c];
        int row = 0;
        int column = 0;
        //转到下一行
        sc.nextLine();
        for (int i = 0; i < r; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                switch (str.charAt(j)) {
                    case 'B': {
                        matrix[i][j] = true;
                        break;
                    }
                    case 'R': {
                        row = i;
                        column = j;
                        matrix[i][j] = true;
                        break;
                    }
                    case 'O': {
                        matrix[i][j] = false;
                        break;
                    }
                    default: {

                    }
                }
            }
        }
        int startr = row;
        int startc = column;
        int n = sc.nextInt();
        String[] direction = {"up", "left", "down", "right"};
        int direct = 0;
        sc.nextLine();
        for (int o = 0; o < n; o++) {
            String order = sc.nextLine();
            String[] s = order.split(" ");
            if ("Turn".equals(s[0])) {
                if ("left".equals(s[1])) {
                    direct++;
                    direct %= 4;
                } else {
                    direct--;
                    if (direct < 0) {
                        direct += 4;
                    }
                }
            } else {
                //前进
                int step = Integer.parseInt(s[1]);
                boolean flag = false;
                for (int i = 0; i < step; i++) {
                    if (flag) {
                        break;
                    }
                    switch (direction[direct]) {
                        case "up": {
                            if (row - 1 < 0 || !matrix[row - 1][column]) {
                                flag = true;
                            } else {
                                row--;
                            }
                            break;
                        }
                        case "left": {
                            if (column - 1 < 0 || !matrix[row][column - 1]) {
                                flag = true;
                            } else {
                                column--;
                            }
                            break;
                        }
                        case "right": {
                            if (column + 1 >= c || !matrix[row][column + 1]) {
                                flag = true;
                            } else {
                                column++;
                            }
                            break;
                        }
                        case "down": {
                            if (row + 1 >= r || !matrix[row + 1][column]) {
                                flag = true;
                            } else {
                                row++;
                            }
                            break;
                        }
                        default: {

                        }
                    }
                }
            }

        }
        System.out.println((row - startr) + " " + (column - startc));

    }
}
