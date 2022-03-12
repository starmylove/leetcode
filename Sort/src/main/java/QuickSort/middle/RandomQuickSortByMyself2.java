package QuickSort.middle;

import java.util.Random;

/**
 * @author 19476
 */
public class RandomQuickSortByMyself2 {
    public void quickSort(int[] nums){
        randomQuickSort(nums,0,nums.length-1);
    }

    private void randomQuickSort(int[] nums, int l, int r) {
        if(l < r){
            int i = randomQuickPartition(nums,l,r);
            randomQuickSort(nums,l,i-1);
            randomQuickSort(nums,i+1,r);
        }
    }
    private int randomQuickPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r-l+1)+l;
        swap(nums,i,r);
        return partition(nums,l,r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1 ;
        for(int j = l ; j <= r - 1 ; j++){
            if(nums[j] <= pivot){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,r);
        return i+1;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}