package QuickSort.easy;

import java.util.*;

public class RandomQuickSort {
    public int findKth(int[] a, int n, int K) {
        return quickSort(a, 0, a.length - 1, K);
    }

    private int quickSort(int[] arr, int left, int right, int k){
        int p = partition(arr, left, right);
        // 改进后，很特殊的是，p是全局下标，只要p对上topK坐标就可以返回
        if (p == arr.length - k) {
            return arr[p];
        }else if (p < arr.length - k) {
            // 如果基准在左边，这在右边找
            return quickSort(arr, p + 1, right,k);
        }else {
            return quickSort(arr, left, p - 1,k);
        }
    }

    private int partition(int[] arr, int left, int right) {
        // 可优化成随机，或中位数
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }
}
