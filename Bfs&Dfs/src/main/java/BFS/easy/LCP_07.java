package BFS.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCP_07 {
    //LCP 07. 传递信息
    int ans = 0 ;
    int len;
    int maxStep;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    public int numWays(int n, int[][] relation, int k) {
        len = n;
        maxStep = k;
        for (int i = 0; i < relation.length; i++) {
            Set<Integer> set = map.getOrDefault(relation[i][0],new HashSet<>());
            set.add(relation[i][1]);
            map.put(relation[i][0],set);
        }
        dfs(0,0);
        return ans;
    }
    public void dfs(int step,int node){
        if(step==maxStep && node == len -1){
            ans++;
            return;
        }
        if(step == maxStep && node!=len - 1) {
            return;
        }
        if(!map.containsKey(node)) {
            return;
        }
        for(int num: map.get(node)) {
            dfs(step+1,num);
        }
    }
    @Test
    public void test(){
        int[][] relations = new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int i = numWays(4,relations, 3);
        System.out.println(i);
    }
}
