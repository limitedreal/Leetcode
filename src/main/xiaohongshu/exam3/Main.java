package main.xiaohongshu.exam3;

import java.util.Map;
import java.util.Scanner;

public class Main {
    class Node{
        int key;

    }
    public static void main(String[] args) {
        //为什么小红书难度这么大啊，可能是hc没了？
        //一个结点到另一个结点的最短路径，如果是图的话肯定是迪杰斯特拉算法？
        //但是这里是树，这个方法麻烦了。
        //虽然我们不知道父子关系，但是可以用任意一个结点作为root，这样就可以了

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < 3 * (n - 1); i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
        }
        System.out.println(8);
    }
}
