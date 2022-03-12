package middle;

import org.junit.Test;

public class num_457 {
    public boolean circularArrayLoop(int[] nums) {
        int length = nums.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            if(!visited[i]){
                if(nums[i]%length==0){
                    visited[i] = true;
                    continue;
                }
                int index = i ;
                boolean[] pathed = new boolean[length];
                while (nums[index]%length!=0){
                    if(pathed[index]) {
                        return true;
                    }
                    if(visited[index]) {
                        break;
                    }
                    visited[index] = true ;
                    pathed[index] = true ;
                    index = ( index + nums[index]+1000*length) % length ;
                }
            }
        }
        return false;
    }

    @Test
    public void test(){
        boolean b = circularArrayLoop(new int[]{-2,1,-1,-2,-2});
        System.out.println(b);
    }
}
