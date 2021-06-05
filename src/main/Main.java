package main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {//实现几种排序方法，这里都默认为从小到大
        //5,4,3,2,1
        //1,2,3,4,5
        //1,5,3,4,2
        //2,1
        //1,2
        //2
        int[] arr1 = {5, 4, 3, 2, 1}, arr2 = {1, 2, 3, 4, 5}, arr3 = {1, 5, 3, 4, 2}, arr4 = {2, 1}, arr5 = {1, 2}, arr6 = {2};
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
        quickSort(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr3));
        quickSort(arr4, 0, arr4.length - 1);
        System.out.println(Arrays.toString(arr4));
        quickSort(arr5, 0, arr5.length - 1);
        System.out.println(Arrays.toString(arr5));
        quickSort(arr6, 0, arr6.length - 1);
        System.out.println(Arrays.toString(arr6));
    }

    //1.快排
    static void quickSort(int[] arr, int low, int high) {
        //根据pivot分成比pivot大和比pivot小的两部分
        //先寻找pivot，然后分治
        if (low < high) {
            int pivot = getPivotIndex(arr, low, high);
            quickSort(arr, low, pivot);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int getPivotIndex(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high) {
                if (arr[high] < pivot) {
                    arr[low] = arr[high];
                    break;
                }
                high--;
            }
            while (low < high) {
                if (arr[low] >= pivot) {
                    arr[high] = arr[low];
                    break;
                }
                low++;
            }
        }
        arr[low] = pivot;
        return low;
    }

    //2.堆排序
    void heapSort() {
        
    }
}
