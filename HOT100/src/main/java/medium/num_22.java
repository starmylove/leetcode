package medium;

import java.util.ArrayList;
import java.util.List;

public class num_22 {
    List<String > ans = new ArrayList<>();
    int n = 0 ;
    public List<String> generateParenthesis(int n) {
        this.n = n ;
        dfs(new StringBuilder(),0, 0);
        return ans ;
    }

    private void dfs(StringBuilder path, int l , int r) {
        if(l == n && r == n){
            ans.add(path.toString());
            return;
        }
        if(l < n){
            path.append('(');
            dfs(path,l+1,r);
            path.replace(path.length()-1,path.length(),"");
        }
        if(r < l){
            path.append(')');
            dfs(path,l,r+1);
            path.replace(path.length()-1,path.length(),"");
        }
    }
}
