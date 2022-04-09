package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums1.length && p < nums2.length; i ++){
            int num1 = nums1[i];
            if(i > 0 && nums1[i] == nums1[i - 1]){
                continue;
            }
            while (p < nums2.length && num1 > nums2[p]) {
                p ++;
            }
            if(p < nums2.length && nums2[p] == num1){
                ans.add(num1);
                while (p < nums2.length - 1 && nums2[p + 1] == nums2[p]){
                    p ++;
                }
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    @Test
    public void test(){
        System.out.println(intersection(new int[]{61, 24, 20, 58, 95, 53, 17, 32, 45, 85, 70, 20, 83, 62, 35, 89, 5, 95, 12, 86, 58, 77, 30, 64, 46, 13, 5, 92, 67, 40, 20, 38, 31, 18, 89, 85, 7, 30, 67, 34, 62, 35, 47, 98, 3, 41, 53, 26, 66, 40, 54, 44, 57, 46, 70, 60, 4, 63, 82, 42, 65, 59, 17, 98, 29, 72, 1, 96, 82, 66, 98, 6, 92, 31, 43, 81, 88, 60, 10, 55, 66, 82, 0, 79, 11, 81}, new int[]{
                5, 25, 4, 39, 57, 49, 93, 79, 7, 8, 49, 89, 2, 7, 73, 88, 45, 15, 34, 92, 84, 38, 85, 34, 16, 6, 99, 0, 2, 36, 68, 52, 73, 50, 77, 44, 61, 48
        }));
    }
}
