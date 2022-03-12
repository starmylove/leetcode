package middle;

import org.junit.Test;

public class num_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE , index = 0 , length = cost.length;
        int sum = 0 ;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if(sum < min){
                min = sum ;
                index = i ;
            }
        }
        return sum<0?-1:(index+1)%length;
    }
    @Test
    public void test(){
        int[] gas = new int[]{1,2,3,4,5} , cost = new int[]{3,4,5,1,2} ;
        int i = canCompleteCircuit(gas, cost);

    }

}
