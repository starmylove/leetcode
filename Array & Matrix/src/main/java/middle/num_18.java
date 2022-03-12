package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_18 {
    //四数之和
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n<4) {
            return new ArrayList<List<Integer>>() ;
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target) {
                break;
            }
            if((i > 0 && nums[i] == nums[ i - 1] )|| nums[i]+nums[n-1]+nums[n-2]+nums[n-3] < target) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                int target1 = target - nums[i] - nums[j];
                if((j > i+1 && nums[j] == nums[j-1] )||  nums[i]+nums[j]+nums[n-1]+nums[n-2] < target) {
                    continue;
                }
                int left = j + 1 , right = n-1 ;
                for (; left < right; left++) {
                    if(nums[i]+nums[j]+nums[right]+nums[right-1]<target) {
                        break;
                    }
                    if(left > j + 1 && nums[left] == nums[left-1]) {
                        continue;
                    }
                    while(left < right && nums[left] + nums[right] > target1) {
                        right--;
                    }
                    if(left==right) {
                        break;
                    }
                    if(nums[left] + nums[right] == target1){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i] );
                        list.add(nums[j] );
                        list.add(nums[left] );
                        list.add(nums[right] );
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
    //
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        if(nums.length<4){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int first=0;first<n-3;first++){
            if(first>0&&nums[first-1]==nums[first]){
                continue;
            }
            if(nums[first]+nums[first+1]+nums[first+2]+nums[first+3]>target){
                break;
            }
            if(nums[first]+nums[n-3]+nums[n-2]+nums[n-1]<target){
                continue;
            }
            for(int fouth=n-1;fouth>=first+3;fouth--){
                if(fouth<n-1&&nums[fouth+1]==nums[fouth]){
                    continue;
                }
                if(nums[first]+nums[fouth-2]+nums[fouth-1]+nums[fouth]<target){
                    break;
                }
                if(nums[first]+nums[first+1]+nums[first+2]+nums[fouth]>target){
                    continue;
                }
                int sum = target-nums[first]-nums[fouth];
                int left=first+1,right = fouth-1;
                while(left<right){
                    if(nums[left]+nums[right]==sum){
                        list.add(Arrays.asList(nums[first],nums[left],nums[right],nums[fouth]));
                        left++;
                        right--;
                        while(left<right&&nums[left]==nums[left-1]){
                            left++;
                        }
                        while(left<right&&nums[right]==nums[right+1]){
                            right--;
                        }
                    }else if(nums[left]+nums[right]<sum){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
