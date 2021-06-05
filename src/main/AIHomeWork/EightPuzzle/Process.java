package main.AIHomeWork.EightPuzzle;

import java.util.Scanner;

public class Process {
    static int[] target = {1, 2, 3, 6, 7, 4, 5, 8, 0};

    static int[] stepNo41 = {5, 4, 3, 6, 7, 8};
    static int[] stepNo71 = {3, 6, 7, 4};
    static int blank;//空格也就是0的位置
    static int i, j;
    static int number = 0;

    static void judge()//找到空格也就是0的位置
    {
        number = 0;
        for (i = 0; i < 9; i++) {
            if (target[i] == 0) {
                blank = i;
                return;
            }
        }
    }

    static void exchange(int x, int y)//交换两个数
    {
        int temp;
        print();
        temp = target[x];
        target[x] = target[y];
        target[y] = temp;
        blank = y;
        number++;
    }

    static void step1() {
        int[] stepNo11 = {3, 0, 1, 2, 5};
        int[] stepNo12 = {6, 7, 8, 5, 2, 1};
        if ((target[2] != 0) && target[2] != 1)
            return;
        else {
            if (blank == 2) {
                if (target[1] == 1)
                    exchange(2, 5);
                else
                    exchange(2, 1);
                return;
            } else {
                if (blank == 4) {
                    exchange(4, 1);
                    i = 2;
                    while (blank != 5) {
                        exchange(stepNo11[i], stepNo11[i + 1]);
                        i++;
                    }
                    return;
                }
                for (i = 0; i < 3; i++) {
                    if (stepNo11[i] == blank) {
                        while (blank != 5) {
                            exchange(stepNo11[i], stepNo11[i + 1]);
                            i++;
                        }
                        return;
                    }
                }
                for (i = 0; i < 4; i++) {
                    if (stepNo12[i] == blank) {
                        while (blank != 1) {
                            exchange(stepNo12[i], stepNo12[i + 1]);
                            i++;
                        }
                        return;
                    }
                }
            }
        }
        return;
    }

    static void step2() {
        int[] stepNo21 = {0, 3, 6, 7, 8, 5, 4, 1};
        for (i = 0; i < 8; i++) {
            if (stepNo21[i] == blank) {
                while (target[0] != 1) {
                    exchange(stepNo21[i % 8], stepNo21[(i + 1) % 8]);
                    i++;
                }
                break;
            }
        }
    }

    static void step3() {
        int[] stepNo31 = {2, 1, 4, 3, 6, 7, 8, 5};
        for (i = 0; i < 8; i++) {
            if (stepNo31[i] == blank) {
                while (target[1] != 2) {
                    exchange(stepNo31[i % 8], stepNo31[(i + 1) % 8]);
                    i++;
                }
                break;
            }
        }
    }

    static void step4() {
        for (i = 0; i < 6; i++) {
            if (stepNo41[i] == blank) {
                while ((target[4] != 3)) {
                    exchange(stepNo41[i % 6], stepNo41[(i + 1) % 6]);
                    i = (i + 1) % 6;
                }
                while (blank != 3) {
                    exchange(stepNo41[i % 6], stepNo41[(i + 5) % 6]);
                    i = (i + 5) % 6;
                }
                break;
            }
        }
    }

    static void step5() {
        int[] stepNo51 = {3, 0, 1, 4, 5, 2, 1, 0, 3};
        i = 0;
        do {
            exchange(stepNo51[i], stepNo51[i + 1]);
            i++;
        } while (blank != 3);
    }

    static void step6() {
        for (i = 0; i < 6; i++) {
            if (stepNo41[i] == blank) {
                while (target[5] != 4) {
                    exchange(stepNo41[i % 6], stepNo41[(i + 1) % 6]);
                    i++;
                }
                if (blank == 8)
                    exchange(8, 7);
                break;
            }
        }
        return;
    }

    static void step7() {
        for (i = 0; i < 4; i++) {
            if (stepNo71[i] == blank) {
                while (target[4] != 5) {
                    exchange(stepNo71[i % 4], stepNo71[(i + 1) % 4]);
                    i = (i + 1) % 4;
                }
                while (blank != 3) {
                    exchange(stepNo71[i % 4], stepNo71[(i + 3) % 4]);
                    i = (i + 3) % 4;
                }
                break;
            }
        }
    }

    static void step8() {
        int[] stepNo81 = {3, 0, 1, 2, 5, 4, 7, 8, 5, 2, 1, 0, 3};
        i = 0;
        do {
            exchange(stepNo81[i], stepNo81[i + 1]);
            i++;
        } while (blank != 3);
    }

    static void step9() {
        for (i = 0; i < 4; i++) {
            if (stepNo71[i] == blank) {
                while (target[7] != 6) {
                    exchange(stepNo71[i % 4], stepNo71[(i + 1) % 4]);
                    i = (i + 1) % 4;
                }
                while (blank != 4) {
                    exchange(stepNo71[i % 4], stepNo71[(i + 3) % 4]);
                    i = (i + 3) % 4;
                }
                break;
            }
        }
    }

    static void print() {
        for (j = 0; j < 9; j++) {
            if (target[j] == 0)
                System.out.print(" \t");
            else
                System.out.print(target[j] + "\t");
            if ((j + 1) % 3 == 0)
                System.out.print("\n");
        }
        System.out.print("************ " + number + "***********\n");
    }

    static void loop() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数码：\n");
        for (i = 0; i < 9; i++) {
            target[i] = sc.nextInt();
        }
        sc.close();
        judge();
        step1();
        step2();
        step3();
        if (target[2] != 3) {
            step4();
            step5();
        }
        step6();
        if (target[8] != 5) {
            step7();
            step8();
        }
        step9();
        print();
        if (!((target[3] == 8) && (target[6] == 7)))
            System.out.println("无解！");
    }

    public static void main(String[] args) {
        loop();
    }

/**
 * 过程式方法，过程式方法抽象程度不高，适用性不强，而且用C编写的话显得更加麻烦了。
 * 可以指定一个初始状态，但是过程式的方法是不能指定一个最终状态的
 * 样例输入：
Process
 */

}
