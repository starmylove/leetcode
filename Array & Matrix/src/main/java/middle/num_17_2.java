package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num_17_2 {
    private List<String> list= new ArrayList<>();
    private StringBuilder sb=new StringBuilder();
    private int len;
    private Map<Character,char[]> map = new HashMap<Character,char[]>(){{
        put('2', new char[]{'a','b','c'});
        put('3', new char[]{'d','e','f'});
        put('4', new char[]{'g','h','i'});
        put('5', new char[]{'j','k','l'});
        put('6', new char[]{'m','n','o'});
        put('7', new char[]{'p','q','r','s'});
        put('8', new char[]{'t','u','v'});
        put('9', new char[]{'w','x','y','z'});
    }};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) {
            return list;
        }
        len=digits.length();
        dfs(digits,0);
        return list;
    }
    public void dfs(String str,int k){
        char[] chars = map.get(str.charAt(k));
        if(k!=len-1) {
            for(char c : chars ) {
                sb.append(c);
                dfs(str,k+1);
                sb.deleteCharAt(sb.length()-1);
            }
        } else{
            for(char c : chars ) {
                sb.append(c);
                list.add(sb.toString());
                sb.deleteCharAt(sb.length()-1);
            }
            return;
        }
    }




}
