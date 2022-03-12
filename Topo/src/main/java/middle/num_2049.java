package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num_2049 {
    long max = 0;
    public int countHighestScoreNodes(int[] parents) {
        List<Integer>[] children =  new List[parents.length];
        for(int i = 0; i < parents.length; i ++){
            children[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i < parents.length; i ++){
            int parent = parents[i];
            children[parent].add(i);
        }
        int[] counts = new int[parents.length];
        dfs(0,children,counts);
        long[] m = new long[parents.length];
        for(int i = 0; i < parents.length; i ++){
            long count;
            if(i == 0){
                count = 1;
            }else{
                count = parents.length - counts[i];
            }
            for(int child : children[i]){
                count *= counts[child];
            }
            max = Math.max(count,max);
            m[i] = count;
        }
        int ans = 0;
        for (int i = 0; i < parents.length; i++) {
            if(m[i] == max){
                ans ++;
            }
        }
        return ans;
    }
    public int dfs(int root, List<Integer>[] children, int[] counts){
        if(children[root].size() == 0){
            counts[root] = 1;
            return 1;
        }
        int count = 1;
        for(int child : children[root]){
            count += dfs(child, children, counts);
        }
        counts[root] = count;
        return count;
    }

    @Test
    public void test(){
        countHighestScoreNodes(new int[]{-1,2,0,2,0});
    }
}
