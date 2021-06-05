package main.AIHomeWork.EightPuzzle;

import java.util.*;

/**
 * @author tyreal <atianlangbo@163.com>
 */

/**
 * 初始状态:
 * 0 1 2
 * 3 4 5
 * 6 7 8
 * 结果状态：
 * 1 2 0
 * 3 4 5
 * 6 7 8
 */
public class BFS {

    private final static int[][] neighbour = {{-1, -1, 3, 1}, {-1, 0, 4, 2}, {-1, 1, 5, -1},
            {0, -1, 6, 4}, {1, 3, 7, 5}, {2, 4, 8, -1},
            {3, -1, -1, 7}, {4, 6, -1, 8}, {5, 7, -1, -1}};//指定怎么走
    private final static int arrangement = 363000;
    private String initialState;
    private String resultState;
    private String[][] arrangeQueue;

    private BFS() {
        arrangeQueue = new String[arrangement][];
        initialState = "";
        resultState = "";
        for (int i = 0; i < arrangement; i++) {
            arrangeQueue[i] = new String[5];
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------------------八数码宽度优先算法实现------------------------");
        BFS eightFigure = new BFS();
        String[] initInputLine = new String[3];
        String[] resultInputLine = new String[3];
        StringBuilder initInput = new StringBuilder();
        StringBuilder resultInput = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int initialIndex = 0;
        int step = 0;
        System.out.println("请输入初始状态：");
        for (int i = 0; i < 3; i++) {
            initInputLine[i] = sc.nextLine();
            initInput.append(initInputLine[i].replace(" ", ""));
        }
        System.out.println("请输入结果状态：");
        for (int i = 0; i < 3; i++) {
            resultInputLine[i] = sc.nextLine();
            resultInput.append(resultInputLine[i].replace(" ", ""));
        }
        eightFigure.initialState = initInput.toString();
        eightFigure.resultState = resultInput.toString();
        if (eightFigure.initialState.length() != 9 || eightFigure.resultState.length() != 9) {
            System.out.println("错误输入，请重试.");
        } else {
            sc.close();
            while (eightFigure.initialState.charAt(initialIndex) != '0') {
                initialIndex++;
            }

            if (!eightFigure.initialState.equals(eightFigure.resultState)) {
                step = eightFigure.bfs(eightFigure.initialState, initialIndex);
            }

            System.out.println("\n总步数：" + step);

        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    private int bfs(String initialState, int initailIndex) {
        Stack<String> printTrace = new Stack<>();    // be used to print trace
        HashMap<String, Integer> record = new HashMap<>();    // record state which has been visited
        int head = 0;
        int tail = 1;
        String temp;
        arrangeQueue[head][0] = initialState;
        arrangeQueue[head][1] = String.valueOf(initailIndex);
        arrangeQueue[head][2] = String.valueOf(head);
        arrangeQueue[head][3] = String.valueOf(head); // cur_index
        arrangeQueue[head][4] = null;  // pre_index
        while (head != tail) {
            char[] cur;
            int position = Integer.parseInt(arrangeQueue[head][1]);
            cur = arrangeQueue[head][0].toCharArray();
            for (int i = 0; i < 4; i++) {
                int swapTo = neighbour[position][i];
                if (swapTo != -1) {
                    swap(cur, position, swapTo);
                    temp = String.valueOf(cur);
                    if (!record.containsKey(temp)) {
                        arrangeQueue[tail][0] = temp;
                        arrangeQueue[tail][1] = String.valueOf(swapTo);
                        arrangeQueue[tail][2] = String.valueOf(Integer.parseInt(arrangeQueue[head][2]) + 1);
                        arrangeQueue[tail][3] = String.valueOf(tail); //cur_index
                        arrangeQueue[tail][4] = arrangeQueue[head][3]; //pre_index
                        tail++;
                        record.put(temp, 1);
                    }
                    if (temp.equals(resultState)) {
                        printTrace.push(temp);
                        String preIndexStr = arrangeQueue[tail - 1][4];
                        while (!preIndexStr.equals("0")) {
                            int preIndex = Integer.parseInt(preIndexStr);
                            printTrace.push(arrangeQueue[preIndex][0]);
                            preIndexStr = arrangeQueue[preIndex][4];
                        }
                        int stepConut = 1;
                        while (!printTrace.isEmpty()) {
                            String printStep = printTrace.pop();
                            System.out.println("\n---------------第" + stepConut + "步---------------");
                            System.out.println(String.format("%c %c %c", printStep.charAt(0), printStep.charAt(1), printStep.charAt(2)));
                            System.out.println(String.format("%c %c %c", printStep.charAt(3), printStep.charAt(4), printStep.charAt(5)));
                            System.out.println(String.format("%c %c %c", printStep.charAt(6), printStep.charAt(7), printStep.charAt(8)));
                            stepConut++;
                        }
                        return Integer.parseInt(arrangeQueue[head][2]) + 1;
                    }
                    swap(cur, position, swapTo);
                }
            }
            head++;
        }
        return tail;
    }

}

