package easy;

import org.junit.Test;

public class checkin {
    private double[] nums;//checkin时间
    private double[] pos;//checkin位置编码
    public void binary(int low , int high){
        int mid = (low + high) / 2;//中间位置
        if(low<high){
            nums[mid] = 1;
        }

    }

    @Test
    public void test(){
        nums = new double[]{1,2,3,5,7,10,12};//checkin时间
        pos = new double[nums.length];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = i+1;//按顺序给checkin位置初始化编码
        }
        binary(0 , nums.length);
        System.out.println(nums);
    }
}

