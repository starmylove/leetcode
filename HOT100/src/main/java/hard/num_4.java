package hard;

public class num_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length , len2 = nums2.length;
        if((len1 + len2) % 2 == 1){
            return findKthNumber(nums1,nums2,(len1+len2)/2+1,0,0);
        }else{
            return ((double)(findKthNumber(nums1,nums2,(len1+len2)/2+1,0,0)+ findKthNumber(nums1,nums2,(len1+len2)/2,0,0)))/2;
        }
    }
    public int findKthNumber(int[] nums1, int[] nums2 , int k , int i , int j){
        if(i == nums1.length){
            return nums2[j+k-1];
        }
        if(j == nums2.length){
            return nums1[i+k-1];
        }
        if(k == 1){
            return Math.min(nums1[i],nums2[j]);
        }else{
            int len = k / 2 ;
            int index1 = (i+len-1) >= nums1.length ? nums1.length - 1 : i+len-1 ;
            int index2 = (j+len-1) >= nums2.length ? nums2.length - 1 : j+len-1 ;
            if(nums1[index1] < nums2[index2]){
                return findKthNumber(nums1,nums2,k-(index1-i)-1,index1+1,j);
            }else{
                return findKthNumber(nums1,nums2,k-(index2-j)-1,i,index2+1);
            }
        }
    }
}
