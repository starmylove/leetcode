package middle;

import org.junit.Test;

import java.util.Arrays;

public class num_274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counter = new int[n+1];
        for (int citation : citations) {
            if (citation >= n) {
                counter[n]++;
            } else {
                counter[citation]++;
            }
        }
        int tot = 0 ;
        for (int i = n; i >= 0 ; i--) {
            tot += counter[i] ;
            if(tot >= i){
                return i;
            }
        }
        return 0;
    }
    @Test
    public void test(){
        int[] citations = new int[]{1,3,1};
        hIndex(citations);
    }
}
