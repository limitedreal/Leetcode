package main.xiecheng.exam1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int count = 0;
    static String[] commands;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        commands = new String[n+1];
        for (int i = 0; i < n+1; i++) {
            commands[i] = sc.nextLine();
        }
        count = 0;
        List<String> path = new LinkedList<>();
        catogroy(path);

    }

    public static void catogroy(List<String> path) {
        count++;
        if (count >= commands.length) {
            return;
        }
        String command = commands[count];
        String[] str = command.split(" ");
        if (str.length == 1) {
            //说明是pwd
            StringBuilder result = new StringBuilder();
            if (path.size() == 0) {
                System.out.println("\\");
            } else {
                for (String s : path) {
                    result.append("\\");
                    result.append(s);
                }
                System.out.println(result);
            }
            catogroy(path);
        } else {
            command = str[1];
            if ("..".equals(command)) {
                if (path.size() == 0) {
                    //说明是根目录
                    catogroy(path);
                } else {
                    path.remove(path.size() - 1);
                    catogroy(path);
                }
            } else {
                path.add(command);
                catogroy(path);
            }
        }
    }
}
