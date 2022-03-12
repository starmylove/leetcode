package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num_17 {
    private List<String> list= new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    private int len;
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) {
            return list;
        }
        len=digits.length();
        dfs(digits,0);
        return list;
    }
    public void dfs(String str,int k){
        char[] chars = null;
        switch (str.charAt(k)){
            case '2':
                chars = new char[]{'a','b','c'};
                break;
            case '3':
                chars = new char[]{'d','e','f'};
                break;
            case '4':
                chars = new char[]{'g','h','i'};
                break;
            case '5':
                chars = new char[]{'j','k','l'};
                break;
            case '6':
                chars = new char[]{'m','n','o'};
                break;
            case '7':
                chars = new char[]{'p','q','r','s'};
                break;
            case '8':
                chars = new char[]{'t','u','v'};
                break;
            case '9':
                chars = new char[]{'w','x','y','z'};
                break;
        }
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
    @Test
    public void test(){
        List<String> ans = letterCombinations("23");
        System.out.println(ans);
    }
}
