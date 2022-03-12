package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num_301_6 {
    //301. 删除无效的括号
    /*
    * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
    * 返回所有可能的结果。答案可以按 任意顺序 返回。
    * */
    Set<String> set = new HashSet<>();
    String s ;
    int len , max  , n ;
    public List<String> removeInvalidParentheses(String _s) {
        s = _s ;
        n = s.length();
        int l =0, r=0 , ll=0 , rr=0 , score=0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '('){
                l++;
                ll++;
            }else if(c == ')'){
                r++ ;
                if(ll>0){
                    ll--;
                }else {
                    rr++;
                }
            }
        }
        max = Math.min(l,r);
        len = n - ll - rr ;
        dfs(0,"",ll,rr,0);
        return new ArrayList<>(set);
    }

    private void dfs(int u, String cur, int ll, int rr, int score) {
        if(ll < 0 || rr < 0 || score < 0 || score > max) {
            return;
        }
        if(u == n){
            if(score == 0 && cur.length() == len){
                set.add(cur);
            }
            return;
        }
        char c = s.charAt(u);
        if(c == '('){
            dfs(u+1,cur+String.valueOf(c),ll,rr,score+1);
            dfs(u+1,cur,ll-1,rr,score);
        }else if(c == ')'){
            dfs(u+1,cur+String.valueOf(c),ll,rr,score-1);
            dfs(u+1,cur,ll,rr-1,score);
        }else {
            dfs(u+1,cur+String.valueOf(c),ll,rr,score);
        }
    }
}










