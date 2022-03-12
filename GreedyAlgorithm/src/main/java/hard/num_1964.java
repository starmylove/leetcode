package hard;

import org.junit.Test;

public class num_1964 {
    //100% 100%
    public int[] longestObstacleCourseAtEachPosition(int[] nums) {
        int[] d = new int[nums.length];
        d[0] = nums[0];
        int maxIndex = 0 ;
        int[] ans = new int[nums.length];
        ans[0] = 1 ;
        Label1 :for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(num >= d[maxIndex]){
                d[++maxIndex] = num ;
                ans[i] = maxIndex+1;
            }
            else{
                int left = 0 , right = maxIndex , mid = 0 ;
                while (left<=right){
                    mid = (left + right ) / 2 ;
                    if(d[mid] == num){
                        int end = mid ;
                        while (end+1<nums.length&&d[end+1]==num) {
                            end++;
                        }
                        if(end+1<nums.length){
                            d[end+1] = num ;
                            ans[i] = end + 2 ;
                        }
                        continue Label1;
                    }
                    if(d[mid]>num) {
                        right = mid-1;
                    } else {
                        left = mid+1;
                    }
                }
                if(right == mid-1){
                    d[mid]=num;
                    ans[i] = mid+1;
                    continue;
                }
                if(left<=maxIndex){
                    d[left]=num;
                    ans[i] = left+1;
                }
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[] length = longestObstacleCourseAtEachPosition(new int[]{3,1,5,6,4,2});
        for (int i = 0; i < length.length; i++) {
            System.out.println(length[i]);
        }
    }
}