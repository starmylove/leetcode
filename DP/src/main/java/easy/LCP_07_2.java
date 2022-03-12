package easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCP_07_2 {
    //动态规划
    public int numWays(int n, int[][] relation, int k) {
        int ans = 0 ;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < relation.length; i++) {
            Set<Integer> set = map.getOrDefault(relation[i][0],new HashSet<>());
            set.add(relation[i][1]);
            map.put(relation[i][0],set);
        }
        int[][] dp = new int[k+1][n];
        dp[0][0] = 1 ;
        for (int step = 0; step < k; step++) {
            for (int node = 0; node < n; node++) {
                if(dp[step][node]!=0 && map.containsKey(node)) {
                    for(int neighbour : map.get(node)) {
                        dp[step + 1][neighbour] += dp[step][node];
                    }
                }
            }
        }
        return dp[k][n-1];
    }
    @Test
    public void test(){
        int[][] relations = new int[][]{{0,2},{2,1},{0,1},{2,0},{1,0},{1,2}};
//        int[][] relations = new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int i = numWays(3,relations, 5);
        System.out.println(i);
    }
}
