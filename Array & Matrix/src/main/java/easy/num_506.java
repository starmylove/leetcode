package easy;

import org.junit.Test;

public class num_506 {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length ;
        int[][] nums = new int[n][2];
        for(int i = 0 ; i < n ; i ++){
            nums[i][0] = score[i];
            nums[i][1] = i ;
        }
        quickSort(nums,0,n - 1) ;
        String[] ans = new String[n] ;
        for(int i = 0 ; i < n ; i ++){
            if(i == 0){
                ans[nums[i][1]] = "Gold Medal";
            }else if(i == 1){
                ans[nums[i][1]] = "Silver Medal";
            }else if(i == 2){
                ans[nums[i][1]] = "Bronze Medal";
            }else{
                ans[nums[i][1]] = String.valueOf(i+1);
            }
        }
        return ans ;
    }
    public void quickSort(int[][] nums , int l , int r){
        if(l >= r) {
            return;
        }
        int pivot = nums[l][0] ;
        int i = l + 1 , j = r ;
        while(i < j){
            while(i <= j && nums[i][0]>= pivot) {
                i ++ ;
            }
            while(j >= i && nums[j][0] <= pivot) {
                j -- ;
            }
            if(i < j){
                swap(nums,i,j);
            }
        }
        if(nums[j][0]>pivot) {
            swap(nums,l,j);
        }
        quickSort(nums,l,j-1);
        quickSort(nums,j+1,r);
    }
    public void swap(int[][] nums,int i,int j){
        int[] temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
    @Test
    public void test(){
        findRelativeRanks(new int[]{10,3,8,9,4});
    }
}
