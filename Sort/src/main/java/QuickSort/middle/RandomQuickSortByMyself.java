package QuickSort.middle;

import java.util.Random;

public class RandomQuickSortByMyself {
    public int[] sortArray(int[] nums){
        randomQuickSort(nums,0,nums.length-1);
        return nums;
    }
    private void randomQuickSort(int[] nums, int left, int right) {
        if(left < right){
            int pos = randomizedPartition(nums,left,right);
            randomQuickSort(nums,left,pos-1);
            randomQuickSort(nums,pos+1,right);
        }
    }
    private int randomizedPartition(int[] nums, int left, int right) {
        int i = new Random().nextInt(right-left+1)+left;
        swap(nums,right,i);
        return partition(nums,left,right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1 ;
        for (int j = left ; j < right ; j ++){
            if(pivot > nums[j]){
                i ++ ;
                swap(nums,i,j);
            }
        }
        swap(nums,right,i+1);
        return i+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
