package hard;

import org.junit.Test;

public class num_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length , n = nums2.length;
        if(((m+n) & 1) == 1){
            return findKth(nums1,nums2,0,0,(m+n)/2+1);
        }else {
            return ((double)(findKth(nums1,nums2,0,0,(m+n)/2+1)+findKth(nums1,nums2,0,0,(m+n)/2)))/2;
        }
    }
    public int findKth(int[] nums1, int[] nums2, int m, int n, int k){
        if(m == nums1.length){
            return nums2[n+k-1];
        }
        if(n == nums2.length){
            return nums1[m+k-1];
        }
        if(k == 1) {
            return Math.min(nums1[m], nums2[n]);
        }
        int mm = Math.min(nums1.length-1,m+(k>>1)-1);
        int nn = Math.min(nums2.length-1,n+(k>>1)-1);
        if(nums1[mm]<=nums2[nn]){
            return findKth(nums1,nums2,mm+1,n,k-(mm - m + 1));
        }else {
            return findKth(nums1,nums2,m,nn+1,k-(nn - n + 1));
        }
    }
    @Test
    public void test(){
        findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
    }

}
