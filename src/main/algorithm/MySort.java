package main.algorithm;

public class MySort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2, 3, 9, 7, 1};
        shellSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void shellSort(int[] arr) {
        shellSort(arr, 0, arr.length - 1);
    }

    public static void shellSort(int[] arr, int start, int end) {
        shellSort(arr, start, end, (end - start + 1) / 2);
    }

    public static void shellSort(int[] arr, int start, int end, int d) {
        if (d <= 1 || d > (end - start + 1) / 2) {
            d = (end - start + 1) / 2;
        }
        for (; d > 0; d--) {
            for (int i = 0; i < d; i++) {
                //对于i+kd序列进行插入排序
                for (int j = start + i; j <= end; j += d) {//待插入的位置
                    for (int k = j - d; k >= start + i; k -= d) {
                        if (arr[k] > arr[k + d]) {
                            swapNode(arr, k, k + d);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }


    public static void heapSort(int[] arr) {
        heapSort(arr, 0, arr.length - 1);
    }

    public static void heapSort(int[] arr, int start, int end) {
        //堆排序
        //第一次是全堆调整，然后一个一个顶调整
        int n = end - start + 1;
        int leave = start + n / 2;
        int nonLeave = leave - 1;
        for (int i = nonLeave; i >= start; --i) {
            adjustNode(arr, i, start, end);
        }
        for (int i = 0; i < n; i++) {
            swapNode(arr, start, end - i);
            adjustNode(arr, start, start, end - i - 1);
        }

    }

    public static void adjustNode(int[] arr, int i, int start, int end) {
        for (int j = i; 2 * j + 1 <= end; ) {
            //当2*j+1>end时，此结点就已经走到叶子结点了
            int child = 2 * j + 1;
            //先赋值为左孩子index
            if (child + 1 <= end) {
                //说明存在右孩子
                child = arr[child] > arr[child + 1] ? child : child + 1;
                //child取左右子孩子中较大值
            }
            if (arr[j] < arr[child]) {
                swapNode(arr, j, child);
                j = child;
            } else {//如果此结点就是最大的那一个，就可以查找下一个结点了
                break;
            }
        }
    }

    public static void swapNode(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
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

}
