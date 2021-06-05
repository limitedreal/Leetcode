package main.wangyi;

public class Main {
    public static void k(int[] arr) {
//给定一个数组，求最大子数组和，以及起始、结束的下标
//{-2, 2, 4, -4, -1, 1, 6, -5}
//输入：一个数组； 输出：子数组和 int、两个下标；
        //15:20前结束！
        //动态规划，可以求出每个元素右边的最大子数组的和
        int n = arr.length;
        int[][] guihua = new int[n][3];//第二个维度要记录：最大和、起始、终点
        guihua[n - 1][0] = arr[n - 1];
        guihua[n - 1][1] = n - 1;
        guihua[n - 1][2] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            //要分为这种情况：右边是负数、右边是正数、本身是正数、本身是负数
            if (guihua[i + 1][0] <= 0) {//那说明不加右边的，只有它本身
                guihua[i][0] = arr[i];
                guihua[i][1] = i;
                guihua[i][2] = i;
            }else{
                guihua[i][0] = guihua[i+1][0]+arr[i];
                guihua[i][1] = i;
                guihua[i][2] = guihua[i+1][2];
            }
        }
        int maxIndex=0;
        for(int i = 0;i<n;i++){
            if(guihua[i][0]>guihua[maxIndex][0]){
                maxIndex = i;
            }
        }
        System.out.println(guihua[maxIndex][0]);
        System.out.println(guihua[maxIndex][1]);
        System.out.println(guihua[maxIndex][2]);

    }
}
