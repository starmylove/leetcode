package middle;

import java.util.ArrayList;
import java.util.List;

public class num_77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k,new ArrayList<Integer>());
        return res;
    }
    public List<List<Integer>> dfs(int start, int n, int k, ArrayList<Integer> path){
        if(k == 0){
            res.add((List<Integer>) path.clone());
            return new ArrayList<>();
        }
        if(n - start + 1 < k){
            return new ArrayList<>();
        }
        path.add(start);
        dfs(start+1,n,k-1,path);
        path.remove(path.size()-1);
        if(start < n){
            dfs(start+1,n,k,path);
        }
        return res;
    }
}
