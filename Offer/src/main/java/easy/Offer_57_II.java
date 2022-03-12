package easy;

import org.junit.Test;

import java.util.ArrayList;

public class Offer_57_II {
    public int[][] findContinuousSequence(int target) {
        int l = 1 , r = 1 , sum = 1 ;
        ArrayList<int[]> ans = new ArrayList<>();
        while(r <= (target + 1 )/2 || sum >= target){
            if(sum == target){
                int[] d = new int[r - l + 1 ];
                for (int i = 0; i < r - l + 1; i++) {
                    d[i] = i + l ;
                }
                ans.add(d);
                sum += ++r ;
            }else if(sum < target){
                sum += ++r ;
            }else {
                sum -= l++;
            }
        }
        int[][] res = new int[ans.size()][];
        int index = 0 ;
        for(int[] d : ans){
            res[index++] = d ;
        }
        return res;
    }
    @Test
    public void test(){
        findContinuousSequence(9);
    }
}
