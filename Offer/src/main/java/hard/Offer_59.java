package hard;

public class Offer_59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length ;
        int[] prefixMax = new int[n] , suffixMax = new int[n] ;
        for (int i = 0; i < n; i++) {
            if(i % k == 0){
                prefixMax[i] = nums[i];
            }else {
                prefixMax[i] = Math.max(nums[i],prefixMax[i-1]);
            }
        }
        for (int i = n - 1; i >= 0 ; i--) {
            if(i == n-1 || (i+1) %k==0){
                suffixMax[i] = nums[i];
            }else {
                suffixMax[i] = Math.max(nums[i],suffixMax[i+1] );
            }
        }
        int[] ans = new int[n-k+1];
        for (int i = 0; i <= n - k ; i++) {
            ans[i] = Math.max(prefixMax[i+k-1],suffixMax[i] );
        }
        return ans ;
    }

    //滑动窗口
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (k <= 1) {
            return nums;
        }
        int[] maxs = new int[nums.length - k + 1];
        int maxIndex = 0;
        // 求出前k项最大元素的索引值
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        for (int begin = 0; begin < maxs.length; begin++) {
            int end = begin + k - 1;
            if (nums[end] > nums[maxIndex]) {
                // 更新最大索引
                maxIndex = end;
            } else if (maxIndex < begin) {
                maxIndex = begin;
                // 最大索引范围不在滑动窗口内
                for (int i = begin + 1; i <= end; i++) {
                    if (nums[i] > nums[maxIndex]) {
                        maxIndex = i;
                    }
                }
            }
            maxs[begin] = nums[maxIndex];
        }
        return maxs;
    }
}
