package middle;
//给你一个包含 n 个整数的数组 nums，
// 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
// 请你找出所有和为 0 且不重复的三元组。
//
import java.util.*;

public class num_15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum_1(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum_1(int[] nums){
        //双指针法
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0 ; i < len-2 ; ++i){
            int start = i + 1 , end = len - 1;

            while(start < end){
                if((nums[start]+nums[end])==-nums[i]){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    lists.add(list);
                }
                if(start < end && (nums[start]+nums[end])>-nums[i]){
                    while(start < end && nums[end-1]==nums[end]) {
                        end--;
                    }
                    end--;
                }else if(start < end && (nums[start]+nums[end])<-nums[i]){
                    while(start < end && nums[start+1]==nums[start]) {
                        start++;
                    }
                    start++;
                }else{
                    while(start < end && nums[end-1]==nums[end]) {
                        end--;
                    }
                    while(start < end && nums[start+1]==nums[start]) {
                        start++;
                    }
                    start++;
                    end--;
                }
            }
            while (i < len-3 && nums[i+1]==nums[i]) {
                i++;
            }
        }
        return lists;
    }
    public static List<List<Integer>> threeSum_2(int[] nums){
        //双指针法
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        //hash法
        List<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int m = 0 ; m < nums.length ; m ++){
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            int target = -nums[m];
            for (int i = 0; i < nums.length-1; i++) {
                if(i == m) {
                    continue;
                }
                List<Integer> list = new ArrayList<>();
                list.add(nums[m]);
                if(hashMap.containsKey(target-nums[i])){
                    list.add(nums[i]);
                    list.add(target-nums[i]);
                    list.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if(o1<o2) {
                                return -1;
                            } else if (o1.equals(o2)) {
                                return 0 ;
                            } else {
                                return 1;
                            }
                        }
                    });
                    set.add(list);
                }
                hashMap.put(nums[i],i);
            }
        }
        for(List<Integer> list : set){
            lists.add(list);
        }
        return lists;
    }
}
