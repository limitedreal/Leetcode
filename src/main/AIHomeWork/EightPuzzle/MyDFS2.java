//package main.AIHomeWork.EightPuzzle;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class MyDFS2 {
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
//        Map<Integer,Integer> snapshoot = new HashMap<>();
//        Stack<int[][]> road = new Stack<>();
//        //我们这里使用栈/队列的方法以便同时实现深度和宽度优先搜索。并且利用快照的方法(将他们组整一个大数)来避免循环
//
//        move(origin,1,0);
//        System.out.println("..................................................");
//        System.out.println("无解");
//    }
//
//    static void move(int[][]now,int depth,int forbidden){//指明
//        // 因为是DFS，所以有保持状态的需求，因为我们传递的是引用。
//        // 方法可以采用还原的方法，亦可以采用深拷贝的方法，深拷贝最多会存在depth*size的开销
//        // 这里因为有maxDepth限制，所以使用深拷贝
//        stepCount++;    //移动步数
//        System.out.println("---------------第" + stepCount + "步---------------");
//        System.out.println("深度：" + depth);
//        printMatrix(now);
//
//        //找到了就直接退出
//        if(isReachTarget(now)){
//            reachTarget();
//        }
//        if(depth>maxDepth){
//            System.out.println("*********************************");
//            System.out.println("到达设定的深度");
//            System.out.println("*********************************");
//            return;
//        }
//
//        for (int i = 0;i<maxDirection;i++) {//开始递归，走4个方向
//
//        }
//
//
//
//    }
//
//    static boolean actualMove(int[][]now,int depth,int direction){
//
//    }
//
//    static boolean isDirectionWorkable(int arr[][],int direction){
//
//    }
//
//    public static void printMatrix(int[][] a) { // 输出二维数组
//        for (int[] ints : a) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }
//    }
//    public static void reachTarget() { // 结束函数
//        stepCount++;    //移动步数
//        System.out.println("结束");
//        System.out.println("共用了" + stepCount + "步");
//        System.exit(0);
//    }
//    static boolean isReachTarget(int[][]now){//判断是否已经到达了目标
//        if(now.length!=target.length){
//            return false;
//        }
//        int n = now.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if(now[i][j]!=target[i][j]){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//}
//
