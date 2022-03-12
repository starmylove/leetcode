package easy;

import org.junit.Test;

public class OfferII_69 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0 , r = n - 1 , mid ;
        while (l < r){
            mid = l + ((r - l) >> 1) ;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                l = mid  + 1;
            }
            else {
                r = mid  ;
            }

        }
        return 0;
    }
    @Test
    public void test(){
        int[] arr = new int[]{24,69,100,99,79,78,67,36,26,19};
        int i = peakIndexInMountainArray(arr);
        System.out.println(i);
    }
}
