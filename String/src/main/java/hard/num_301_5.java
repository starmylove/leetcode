package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num_301_5 {
    String s ;
    int n , len , max;
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String _s) {
        n = _s.length();
        s = _s ;
        int l = 0 ,ll=0,rr=0, r = 0  , score = 0 ;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                ll++;
                l++;
            }else if(s.charAt(i) == ')'){
                rr++;
                if(l > 0 ){
                    l--;
                }else {
                    r++;
                }
            }
        }
        max = Math.min(ll,rr);
        len = n - l - r ;
        dfs(0,"",l,r,0);
        return new ArrayList<>(set);
    }

    private void dfs(int u, String cur,int l , int r , int score) {
        if(l < 0 || r < 0 || score<0 || score > max) {
            return;
        }
        if(u == n){
            if(score == 0 && cur.length() == len){
                set.add(cur);
            }
            return;
        }
        char c = s.charAt(u) ;
        if(c == '(' ){
            dfs(u+1,cur+String.valueOf(c),l,r,score+1);
            dfs(u+1,cur,l-1,r,score);
        }else if(c == ')'){
            dfs(u+1,cur+String.valueOf(c),l,r,score-1);
            dfs(u+1,cur,l,r-1,score);
        }else {
            dfs(u+1,cur+String.valueOf(c),l,r,score);
        }
    }
}

















