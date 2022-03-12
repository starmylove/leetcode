package middle;

public class num_413 {
    //413. 等差数列划分
    /*
    * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
    *       例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
    *           给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
    *           子数组 是数组中的一个连续序列。
    * */
    //100% 81%
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) {
            return 0;
        }
        int ans = 0 , d = nums[1] - nums[0] , t = 0 ;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == d ) {
                t++;
            } else {
                t = 0 ;
                d = nums[i] - nums[i - 1 ] ;
            }
            ans += t;
        }
        return ans;
    }

    //实现自己的思路
    //100% 39%
    public int numberOfArithmeticSlices1(int[] nums) {
        if(nums.length<3) {
            return 0;
        }
        int left = 0 , right = 1  , d = nums[right] - nums[left] , ans = 0 , t = 0 ;
        while (right<nums.length){
            if(right <= left + 1) {
                t = 0 ;
            }
            else {
                if(nums[right]-nums[right-1] == d) {
                    t++;
                } else {
                    left = right - 1 ;
                    d = nums[right] - nums[left];
                    t = 0 ;
                }
            }
            right++;
            ans += t;
        }
        return ans ;
    }
    //宫水三叶
    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; ) {
            int j = i, d = nums[i + 1] - nums[i];
            while (j + 1 < n && nums[j + 1] - nums[j] == d) {
                j++;
            }
            int len = j - i + 1;
            // a1：长度为 len 的子数组数量；an：长度为 3 的子数组数量
            int a1 = 1, an = len - 3 + 1;
            // 符合条件（长度大于等于3）的子数组的数量为「差值数列求和」结果
            int cnt = (a1 + an) * an / 2;
            ans += cnt;
            i = j;
        }
        return ans;
    }
    //复现宫水三叶大佬代码
    public int numberOfArithmeticSlices3(int[] nums) {
        if(nums.length<3) {
            return 0;
        }
        int ans = 0 ;
        for(int i = 0 ; i < nums.length-2 ; ){
            int j = i , d = nums[i+1] - nums[i];
            while (j + 1 < nums.length && nums[j + 1] - nums[j] == d) {
                j++;
            }
            int len = j - i + 1 ;
            ans += (len - 1) * ( len - 2 ) / 2 ;
            i = j ;
        }
        return ans;
    }


}
