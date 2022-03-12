package QuickSort.middle;

import org.junit.Test;

public class num_75 {
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }
    public void quickSort(int[] nums, int left, int right){
        if(left>=right) {
            return;
        }
        int i = left , j = right;
        int pivot = nums[i++];
        while (i < j){
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (j >= i && nums[j] >= pivot) {
                j--;
            }
            if(j > i) {
                swap(nums , i , j);
            }
        }
        if(nums[left]>nums[j]) {
            swap(nums,left,j);
        }
        quickSort(nums,left,j-1);
        quickSort(nums,j+1,right);
    }
    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    @Test
    public void test(){
        int[] nums = new int[]{10,3,8,9,4};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
