package easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Random;

public class Offer_40 {
    //剑指 Offer 40. 最小的k个数
    /*
     * 输入整数数组 arr ，找出其中最小的 k 个数。
     * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * */
    //官方题解
    public int[] getLeastNumbers3(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;//pivot 是数组中第 pos - l + 1 小的数
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if(k==0||arr.length==0) {
            return new int[0];
        }
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0||arr.length==0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b) ->b-a);
        for (int i = 0; i < arr.length; i++) {
            if(queue.size()==k&&arr[i]<queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
            if(queue.size()<k) {
                queue.offer(arr[i]);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
    @Test
    public void test(){
        int[] nums = new int[]{0,0,1,2,4,2,2,3,1,4};
        int[] leastNumbers = getLeastNumbers3(nums, 5);
        for(int i : leastNumbers) {
            System.out.println(i);
        }
    }
}
