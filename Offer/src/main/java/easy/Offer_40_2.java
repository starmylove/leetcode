package easy;

import java.util.Random;

public class Offer_40_2 {
    //剑指 Offer 40. 最小的k个数
    /*
     * 输入整数数组 arr ，找出其中最小的 k 个数。
     * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * */
    //官方题解
    public int[] getLeastNumbers(int[] arr, int k) {
        randomizedSelected(arr,0,arr.length-1,k);
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = arr[i];
        }
        return ans;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if(l>=r) {
            return;
        }
        int pos = randomizedPartition(arr,l,r);
        int num = pos - l + 1 ;
        if(num == k) {
            return;
        } else if(num < k){
            randomizedSelected(arr,pos + 1 , r , k - num);
        }else {
            randomizedSelected(arr, l , pos-1 , k );
        }
    }

    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r-l+1) + l ;
        swap(nums , i , r);
        return partition(nums , l , r);
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l-1;
        for(int j = l ; j<r ; j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr,i,r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



















