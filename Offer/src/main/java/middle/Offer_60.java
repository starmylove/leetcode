package middle;

import org.junit.Test;

public class Offer_60 {
    int n ;
    double x = 1.0;
    double[] ans;
    public double[] dicesProbability(int n) {
        this.n = n ;
        ans = new double[5 * n + 1];
        for(int i = 0 ; i < n ; i ++){
            x *= 1.0/6;
        }
        dfs(1,0);
        return ans ;
    }
    public void dfs(int dice , int sum){
        if(dice == n + 1){
            ans[sum-n] += x ;
            return;
        }
        for(int i = 0 ; i < 6 ; i ++){
            dfs(dice+1,sum+i+1);
        }
    }
    @Test
    public void test(){
        dicesProbability(1);
    }
}
