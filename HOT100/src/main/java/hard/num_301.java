package hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num_301 {
    Set<String> ans = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int lremove = 0 , rremove = 0 ;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                lremove ++ ;
            }else if(s.charAt(i) == ')'){
                if(lremove > 0){
                    lremove -- ;
                }else {
                    rremove ++ ;
                }
            }
        }
        dfs(s,new StringBuilder(),0,lremove,rremove,0,0);
        return new ArrayList<>(ans);
    }

    private void dfs(String s, StringBuilder path, int index, int lremove, int rremove,int l,int r) {
        if(lremove < 0 || rremove < 0 || l < r){
            return;
        }
        if(index == s.length() && lremove == 0 && rremove == 0){
            ans.add(path.toString());
            return;
        }
        if( index + lremove + rremove > s.length()){
            return;
        }
        if(s.charAt(index) == '('){
            dfs(s,path,index + 1 ,lremove - 1,rremove,l,r);
            path.append('(');
            dfs(s,path,index + 1,lremove,rremove,l + 1,r);
            path.setLength(path.length()-1);
        }else if(s.charAt(index) == ')'){
            dfs(s,path,index + 1 ,lremove ,rremove - 1,l,r);
            path.append(')');
            dfs(s,path,index + 1,lremove,rremove,l,r + 1);
            path.setLength(path.length()-1);
        }else {
            path.append(s.charAt(index));
            dfs(s,path,index + 1 ,lremove,rremove,l,r);
            path.setLength(path.length()-1);
        }
    }
    @Test
    public void test(){
        System.out.println(removeInvalidParentheses("((i)"));
    }
}
