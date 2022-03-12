package middle;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num_128{
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])!=null) {
                continue;
            }
            int numi = 0 ;
            if(map.get(nums[i]-1)==null && map.get(nums[i]+1)==null){
                map.put(nums[i],1);
                numi = 1 ;
            }else if(map.get(nums[i]-1)!=null && map.get(nums[i]+1)==null){
                numi = map.get(nums[i]-1)+1;
                map.put(nums[i],numi);
                int j = nums[i] - 1 ;
                while (map.get(j)!=null){
                    map.put(j--,numi);
                }
            }else if(map.get(nums[i]-1)==null && map.get(nums[i]+1)!=null){
                numi = map.get(nums[i]+1)+1;
                map.put(nums[i],numi);
                int j = nums[i] + 1 ;
                while (map.get(j)!=null){
                    map.put(j++,numi);
                }
            }else {
                numi = map.get(nums[i]+1)+1+map.get(nums[i]-1);
                map.put(nums[i],numi);
                int j = nums[i] + 1 ;
                while (map.get(j)!=null){
                    map.put(j++,numi);
                }
                int l = nums[i] - 1 ;
                while (map.get(l)!=null){
                    map.put(l--,numi);
                }
            }
            ans = Math.max(ans,numi);
        }
        return ans ;
    }
    //官方题解
    public int longestConsecutive1(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
    public int longestConsecutive2(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums ){
            set.add(num);
        }
        int ans = 0 ;
        for(int num : set){
            if(!set.contains(num-1)){
                int curnum = num + 1 , curlen = 1 ;
                while (set.contains(curnum++)){
                    curlen++;
                }
                ans = Math.max(ans , curlen);
            }
        }
        return ans ;
    }
    //100%
    public int longestConsecutive3(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i:nums){
            if(i<min){
                min=i;
            }
            if(i>max){
                max=i;
            }
        }
        int[] minRange=new int[nums.length];
        int[] maxRange=new int[nums.length];
        int minLeft=min,minRight=min+nums.length-1;
        int maxLeft=max-nums.length+1,maxRight=max;
        for(int i:nums){
            if(minLeft<=i&&i<=minRight){
                minRange[i-minLeft]=1;
            }
            if(maxLeft<=i&&i<=maxRight){
                maxRange[i-maxLeft]=1;
            }
        }
        int minLen=0,maxLen=0;
        int minCur=0,maxCur=0;
        for(int i=0;i<minRange.length;++i){
            if(minRange[i]==1){
                ++minCur;
                if(minCur>minLen){
                    minLen=minCur;
                }
            }else{
                minCur=0;
            }
            if(maxRange[i]==1){
                ++maxCur;
                if(maxCur>maxLen){
                    maxLen=maxCur;
                }
            }else{
                maxCur=0;
            }
        }
        return minLen>maxLen?minLen:maxLen;
    }
    @Test
    public void test(){
        int i = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(i);
    }
}
