package QuickSort.easy;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,2,1};
        quickSort(nums,0, nums.length-1);
        for(int i : nums){
            System.out.println(i);
        }
    }
    public static void quickSort1(int[] nums , int left , int right){

    }
    public static void quickSort(int[] nums , int left , int right){
        if(left>=right) {
            return;
        }
        int i = left , j = right;
        int pivot = nums[i++];
        while (i < j){
            while(i <= j && nums[i] <= pivot){
                i ++ ;
            }
            while (i <= j && nums[j] >= pivot){
                j -- ;
            }
            if(j > i){
                swap(nums,i,j);
            }
        }
        //1.  01122
        //2.  01111
        //3.  10000
        //4.  12
        //[1,2]时，需要判断一下是否需要交换
        if(pivot>nums[j]) {
            swap(nums,left,j);
        }
        quickSort(nums,left,j-1);
        quickSort(nums,j+1,right);
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
}
