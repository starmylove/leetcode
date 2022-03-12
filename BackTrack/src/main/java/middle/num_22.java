package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num_22 {
    List<String> res = new ArrayList<>();
    int len ;
    StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        len = n * 2;
        dfs(n,0,0,0);
        return res ;
    }

    private void dfs(int n ,int index ,int l, int r) {
        if(r > l || l > n){
            return;
        }
        if(l == n){
            for(int i = 0 ; i < n - r ; i++){
                path.append(')');
            }
            res.add(path.toString());
            path.replace(path.length()- n + r,path.length(),"");
            return;
        }
        if(l == n && r == n && index == len){
            res.add(path.toString());
            return;
        }
        path.append('(');
        l ++;
        dfs(n,index + 1 , l , r);
        path.replace(path.length()-1,path.length(),"");
        l -- ;
        if(r != l){
            path.append(')');
            r ++;
            dfs(n,index + 1 , l  , r );
            path.replace(path.length()-1,path.length(),"");
        }
    }
    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
}
