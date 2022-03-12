package middle;

import org.junit.Test;

import javax.xml.bind.annotation.XmlAnyAttribute;
import java.awt.*;

public class num_300_2 {
    //99% 29%
    public int lengthOfLIS(int[] nums) {
        int[] d = new int[nums.length];
        d[0] = nums[0];
        int maxIndex = 0 ;
        Label1 :for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(num > d[maxIndex]) {
                d[++maxIndex] = num ;
            } else if(num == d[maxIndex]) {
                continue;
            } else{
                int left = 0 , right = maxIndex , mid = 0 ;
                while (left<=right){
                    mid = (left + right ) / 2 ;
                    if(d[mid] == num){
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
                    continue;
                }
                if(left<=maxIndex) {
                    d[left]=num;
                }
            }
        }
        return maxIndex+1;
    }
    @Test
    public void test(){
        int length = lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12});
        System.out.println(length);

    }
    
}
