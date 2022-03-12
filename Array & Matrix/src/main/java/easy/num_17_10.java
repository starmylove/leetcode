package easy;

public class num_17_10 {
    //面试题 17.10. 主要元素
    /*
    * 数组中占比超过一半的元素称之为主要元素。
    * 给你一个 整数 数组，找出其中的主要元素。
    * 若没有，返回 -1 。
    * 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
    * */
    public int majorityElement(int[] nums) {
        int length = nums.length;
        if(length==0) {
            return -1;
        }
        if(length==1) {
            return nums[0];
        }
        int candidate = nums[0];
        int count = 0 ;
        for (int i = 0; i < length; i++) {
            if(count==0) {
                candidate = nums[i];
            }
            if(candidate == nums[i]){
                count++;
            }
            else {
                count--;
            }
        }
        count = 0 ;
        for (int num : nums){
            if(num == candidate) {
                count++;
            }

        }
        return count*2>length?candidate:-1;
    }
}
