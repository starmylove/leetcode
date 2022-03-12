package easy;

public class num_70 {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int l = 1 , r = 2 ;
        for(int i = 3 ; i <= n ; i ++){
            int temp = r ;
            r += l ;
            l = temp;
        }
        return r;
    }
}
