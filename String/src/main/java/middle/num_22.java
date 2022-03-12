package middle;

import org.junit.Test;

import java.util.*;

public class num_22 {
    //22. 括号生成
    public List<String> generateParenthesis(int n) {
        List<List<String>> list = new ArrayList<>();
        List<String> l0 = new ArrayList<>();
        l0.add("");
        List<String> l1 = new ArrayList<>();
        l1.add("()");
        list.add(l0);
        list.add(l1);
        for (int i = 2; i <= n; i++) {
            List<String> set = new ArrayList<>();
            for (int j = 0; j < i ; j++) {
                for(String leftString : list.get(j)) {
                    for(String rightString : list.get(i - j - 1)) {
                        set.add("(" + leftString + ")" + rightString);
                    }
                }
            }
            list.add(set);
        }
        List<String> ans = new LinkedList<>();
        for(String s: list.get(n)) {
            ans.add(s);
        }
        return ans;
    }
    public List<String> generateParenthesis1(int n) {
        int l = 0 , r = 0 ;
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        dfs(ans,0,0,n,sb);
        return ans ;
    }
    public void dfs(List<String> ans , int l , int r , int n , StringBuilder path){
        if( r > l ) {
            return;
        }
        if( l == n && r == n){
            ans.add(path.toString());
            return;
        }
        if( l == n ){
            StringBuilder rr = new StringBuilder("");
            for(int i = 0 ; i < n - r ; i++){
                rr.append(")");
            }
            ans.add(path.toString()+rr.toString());
            return ;
        }
        dfs(ans,l+1,r,n,path.append("("));
        path.replace(path.length()-1,path.length(),"");
        dfs(ans,l,r+1,n,path.append(")"));
        path.replace(path.length()-1,path.length(),"");

    }
    @Test
    public void test(){
        Set<String >  set = new HashSet<>();
        set.add("S");
        set.add(new String("S"));
        System.out.println(set.size());
    }
    @Test
    public void test1(){
        List<String> list = generateParenthesis1(3);
        System.out.println(list);
    }
}
