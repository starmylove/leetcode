package middle;

import org.junit.Test;

import java.util.Arrays;

public class num_846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int len = hand.length ;
        if(len % groupSize != 0){
            return false ;
        }
        int cntLen = 0 ;
        for(int i = 0 ; i < len ; i++){
            if(i > 0 && hand[i] == hand[i-1]){
                continue;
            }
            cntLen ++ ;
        }
        int index = 0 ;
        int[] cnt = new int[cntLen] , nums = new int[cntLen];
        for(int i = 0 ; i < len ; i++){
            if(i == 0 || hand[i] != hand[i-1]){
                cnt[index] ++ ;
                nums[index ++] = hand[i] ;
            }else{
                cnt[index - 1] ++;
            }
        }
        int start = 0 ;
        for(int i = 0 ; i < len / groupSize ; i ++){
            boolean startFound = false ;
            int r = start + groupSize , l = start;
            for(int j = start ; j < r; j ++){
                if(j >= cntLen || cnt[j] == 0 || (j > l && nums[j] - nums[j - 1] > 1)){
                    return false;
                }
                if((--cnt[j]) > 0 && ! startFound ){
                    start = j ;
                    startFound = true ;
                }
            }
            if(!startFound){
                start += groupSize ;
            }
        }
        return true;
    }
    @Test
    public void test(){
        isNStraightHand(new int[]{1,1,2,2,3,3},2);
    }
}
