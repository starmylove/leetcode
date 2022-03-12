package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num_17 {
    Map<Integer,char[]> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
        dfs(digits,0,new StringBuilder());
        return ans ;
    }

    private void dfs(String digits, int index, StringBuilder path) {
        if(index == digits.length()){
            if(path.length()>0){
                ans.add(path.toString());
            }
            return;
        }
        for(char c : map.get(digits.charAt(index) - '0')){
            path.append(c);
            dfs(digits,index+1,path);
            path.replace(path.length()-1,path.length(),"");
        }
    }
}
