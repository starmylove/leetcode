package hard;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class num_847 {
    public int shortestPathLength(int[][] graph) {
        int ans = 0 ;
        int n = graph.length ;
        boolean[][] seen = new boolean[n][1 << n] ;
        Queue<int[] > queue = new LinkedList<int[]>() ;
        for (int i = 0; i < n ; i++) {
            queue.offer(new int[]{i , 1 << i , 0}) ;
            seen[i][1 << i] = true ;
        }
        while (!queue.isEmpty()){
            int[] triple = queue.poll();
            if(triple[1]==(1 << n) - 1){
                ans = triple[2];
                break;
            }
            for(int v : graph [ triple[0] ]){
                int maskV = triple[1] | (1 << v);
                if(!seen[v][maskV]){
                    seen[v][maskV]=true;
                    queue.offer(new int[]{v,maskV,triple[2]+1});
                }
            }
        }
        return ans ;
    }
    @Test
    public void test(){

    }
}
