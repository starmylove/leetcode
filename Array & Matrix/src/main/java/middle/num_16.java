package middle;
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
// 找出 nums 中的三个整数，使得它们的和与 target 最接近。
// 返回这三个数的和。假定每组输入只存在唯一答案。


import java.util.Arrays;

public class num_16 {
    public static void main(String[] args) {
        int[] nums = new int[]{-3,-2,-5,3,-4};
        int ans = threeSumClosest(nums, -1);
        System.out.println(ans);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int best = 10000000 ;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len-2; i++) {
            if(i>0&&nums[i]==nums[i-1]) {
                continue;
            }
            int l = i + 1 , r = len-1;
            for( l = i + 1 ; l < r ;  ){
                if(l>i+1&&nums[l]==nums[l-1]) {
                    continue;
                }
                int sum = nums[i]+nums[l]+nums[r];
                if(sum == target) {
                    return sum;
                }
                int a = Math.abs(best-target),b=Math.abs(sum-target);
                if(a>b){
                    best = sum;
                }
                if(l+1==r) {
                    break;
                }
                if(sum<target){
                    while(l<r&&nums[l]==nums[l+1]) {
                        l++;
                    }
                    l++;
                }
                else {
                    while(l<r&&nums[r]==nums[r-1]) {
                        r--;
                    }
                    r--;
                }
            }
        }
        return best;
    }

    public static int threeSumClosest_1(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}
