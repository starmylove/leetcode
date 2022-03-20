package BFS.middle;

import org.junit.Test;

import java.util.*;

public class num_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degrees = new int[n];
        List<List<Integer>> nebs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nebs.add(new ArrayList<>());
        }
        List<Integer> ans = null;
        for(int[] edge : edges){
            int a = edge[0], b = edge[1];
            degrees[a] ++;
            degrees[b] ++;
            nebs.get(a).add(b);
            nebs.get(b).add(a);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if(degrees[i] == 1){
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()){
            ans = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int poll = deque.poll();
                ans.add(poll);
                for(int neb : nebs.get(poll)){
                    degrees[neb] --;
                    if(degrees[neb] == 1){
                        deque.offer(neb);
                    }
                }
            }
        }
        return ans;
    }
    @Test
    public void test(){
        List<Integer> minHeightTrees = findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
        int size = minHeightTrees.size();
        System.out.println(size);
    }

}
