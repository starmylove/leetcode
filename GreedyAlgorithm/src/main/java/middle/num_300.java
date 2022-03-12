package middle;

public class num_300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] d = new int[length];
        d[0] = nums[0] ;
        int index = 0 ;
        for (int i = 1; i < length; i++) {
            binaryInsert(d,nums[i],0,i );
        }
        return 0;
    }
    public void binaryInsert(int[] d , int num ,int i , int j){
        //找到第一个比num大的下标，将该下标的值置为num
        int left = i , right = j ;
        int mid =0 ;
        boolean flag = false ;
        while (left<=right){
            mid = (left + right ) / 2 ;
            if(d[mid] == num){
                flag = true;
                break;

            }
            if(d[mid]>num) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if(flag) {
            return;
        }
        if(right == mid-1){
            d[mid] = num ;
            return;
        }
        if(left==mid+1&&left<=j) {
            d[left] = num ;
        }

    }
}
