//package main.AIHomeWork.EightPuzzle;
//
//import java.util.Scanner;
//
//public class MyDFS {
//    static int dim = 3;
//    static int[][] target = new int[dim][dim];//= { { 1, 2, 3 }, { 8, 0, 4 }, { 7, 6, 5 } };
//    //即要寻找的最终状态
//    static int stepCount = 0;        //用于记录移动步数
//    static int maxDepth = 5;    //用于记录深度
//    static int maxDirection = 4;
//
//    public static void main(String[] args) {
//        int[][] origin = new int[dim][dim];
//
//        System.out.println("-------------------------八数码深度优先算法实现------------------------");
//        try (Scanner sc = new Scanner(System.in)) {
//            System.out.println("请输入初始状态：");
//            for (int i = 0; i < dim; i++) {
//                for (int j = 0; j < dim; j++) {
//                    int temp = sc.nextInt();
//                    origin[i][j] = temp;
//                }
//            }
//            System.out.println("请输入最终状态：");
//            for (int i = 0; i < dim; i++) {
//                for (int j = 0; j < dim; j++) {
//                    int temp = sc.nextInt();
//                    target[i][j] = temp;
//                }
//            }
//        }
//        move(origin, 1, 0);
//        System.out.println("..................................................");
//        System.out.println("无解");
//    }
//
//    static void move(int[][] now, int depth, int forbidden) {//forbidden指明不允许走哪个方向
//        // （1，不能右移 2，不能下移 3，不能左移 4，不能上移）
//        // 因为是DFS，所以有保持状态的需求，因为我们传递的是引用。
//        // 方法可以采用还原的方法，亦可以采用深拷贝的方法，深拷贝最多会存在depth*size的开销
//        // 我们这里使用还原法，因为还原是很简单的。
//        stepCount++;    //移动步数
//        int n = now.length;
//        int[][] target = MyDFS.target;
//        System.out.println("---------------第" + stepCount + "步---------------");
//        System.out.println("深度：" + depth);
//        printMatrix(now);
//
//        //找到了就直接退出
//        if (isReachTarget(now)) {
//            reachTarget();
//        }
//        if (depth > maxDepth) {
//            System.out.println("*********************************");
//            System.out.println("到达设定的深度");
//            System.out.println("*********************************");
//            return;
//        }
//
//        int num1 = -1;
//        int num2 = -1;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (now[i][j] == 0) {
//                    num1 = i;// 空格所在的行
//                    num2 = j;// 空格所在的列
//                }
//            }
//        }
//        if (num2 <= 1 && forbidden != 1) {//可以右移
//            System.out.println("右移：");
//            //右移了
//            int t = now[num1][num2];
//            now[num1][num2 + 1] = t;
//            now[num1][num2] = 0;
//            if (isReachTarget(now)) {
//                reachTarget();
//            }else{
//                move(now,depth+1,3);//这次刚刚右移，下次不允许左移
//            }
//        }
//
//
//    }
//
//    static boolean actualMove(int[][] now, int depth, int direction) {
//
//    }
//
//    static boolean isDirectionWorkable(int arr[][], int direction) {
//
//    }
//
//    public static void printMatrix(int a[][]) { // 输出二维数组
//        for (int[] ints : a) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void reachTarget() { // 结束函数
//        stepCount++;    //移动步数
//        System.out.println("结束");
//        System.out.println("共用了" + stepCount + "步");
//        System.exit(0);
//    }
//
//    static boolean isReachTarget(int[][] now) {//判断是否已经到达了目标
//        if (now.length != target.length) {
//            return false;
//        }
//        int n = now.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (now[i][j] != target[i][j]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//}
