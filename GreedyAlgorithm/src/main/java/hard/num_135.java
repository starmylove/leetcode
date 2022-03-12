package hard;

import org.junit.Test;

public class num_135 {
    int index = 0 ;
    int[] cost ;
    int length ;
    public int candy(int[] ratings) {
        if(ratings.length==1) {
            return 1;
        }
        cost = new int[length];
        length = ratings.length;
        while (index!=length) {
            dfs(ratings);
        }
        int ans = 0 ;
        for(int i : cost) {
            ans += i ;
        }
        return ans;
    }
    public void dfs(int[] ratings){
        if(index == 0){
            if(ratings[1]>=ratings[0]){
                cost[index++] = 1 ;
            }else {
                index++;
                dfs(ratings);
                cost[0] = cost[1] + 1;
            }
            return;
        }
        if(index == length - 1){
            cost[length-1] = ratings[length-2] >= ratings[length-1]?1:cost[length-2]+1;
            index++;
            return;
        }
        if(ratings[index]>ratings[index-1] && ratings[index]>ratings[index+1]){
            int i = index++ ;
            dfs(ratings);
            cost[i] = Math.max(cost[i-1],cost[i+1] )+1;
        }else if(ratings[index]>ratings[index-1] && ratings[index]<=ratings[index+1]){
            cost[index] = 1 + cost[index-1];
            index++;
        }else if(ratings[index]<=ratings[index-1] && ratings[index]>ratings[index+1]){
            int i = index;
            index++;
            dfs(ratings);
            cost[i] = 1 + cost[i+1];
        }else {
            cost[index++] = 1 ;
        }
    }
    @Test
    public void test(){
        int[] gas = new int[]{1,0,2,3,2,2,4,5,6,2} ;
        int i = candy(gas);
        System.out.println(i);
    }
}
