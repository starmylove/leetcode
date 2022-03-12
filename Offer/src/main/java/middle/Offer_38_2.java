package middle;

import java.util.HashSet;
import java.util.Set;

public class Offer_38_2 {
    private Set<String> set = new HashSet<>();
    private StringBuilder sb = new StringBuilder();
    private boolean[] visited;
    private int len;
    public String[] permutation(String s) {
        len = s.length();
        visited=new boolean[len];
        dfs(s,0);
        String[] ans = new String[set.size()];
        int i = 0 ;
        for(String str : set){
            ans[i++] = str;
        }
        return ans;
    }

    private void dfs(String str , int k) {
        for(int i = 0 ; i < str.length() ; i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(str.charAt(i));
                if(k == len-1) {
                    set.add(sb.toString());
                } else {
                    dfs(str,k+1);
                }
                visited[i] = false;
                sb.deleteCharAt(k);
            }
        }
    }
}
