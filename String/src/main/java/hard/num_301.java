package hard;

import org.junit.Test;

import java.util.*;

public class num_301 {
    Set<String> set = new HashSet<>();
    int n ,len;
    public List<String> removeInvalidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(') {
                stack.push(s.charAt(i));
            } else if(!stack.isEmpty() && s.charAt(i)==')' && stack.peek()=='('){
                stack.pop();
                n+=2;
            }else if(s.charAt(i)!='('&&s.charAt(i)!=')'){
                n+=1;
            }
        }
        len = s.length() ;
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(arr,sb,0,0,0);
        if(n==0) {
            set.add("");
        }
        return new ArrayList<>(set);

    }
    void dfs(char[] arr,StringBuilder sb , int num ,int curLen,int index){
        if(num == 0 && curLen == n){
            set.add(sb.toString());
            return;
        }
        if(index == len) {
            return;
        }
        char c = arr[index];
        if(c == '('){
            //选
            sb.append('(');
            dfs(arr,sb,num+1,curLen+1,1+index);
            //不选
            sb.deleteCharAt(sb.length()-1);
            dfs(arr,sb,num,curLen,1+index);
        }else if(c == ')'){
            if(num==0){
                dfs(arr,sb,num,curLen,1+index);
            }else {
                //选
                sb.append(')');
                dfs(arr,sb,num-1,curLen+1,1+index);
                //不选
                sb.deleteCharAt(sb.length()-1);
                dfs(arr,sb,num,curLen,1+index);
            }
        }else {
            //选
            sb.append(c);
            dfs(arr,sb,num,curLen+1,1+index);
            //不选
            sb.deleteCharAt(sb.length()-1);
            dfs(arr,sb,num,curLen,1+index);
        }
    }
    @Test
    public void test(){
        List<String> list = removeInvalidParentheses("))))");
        for(String s : list) {
            System.out.println(s);
        }
    }
}





