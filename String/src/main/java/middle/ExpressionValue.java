package middle;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 19476
 */
public class ExpressionValue {
    Map<Character,Integer> map = new HashMap<Character,Integer>(){{
        put('-',1);
        put('+',1);
        put('*',2);
    }};
    public int solve (String s) {
        // write code here
        s.replaceAll(" ","");
        char[] cs = s.toCharArray();
        int n = s.length();
        Deque<Integer> nums = new ArrayDeque();
        Deque<Character> ops = new ArrayDeque();
        for(int i = 0 ; i < n ; i ++){
            char c = cs[i];
            if(c == '('){
                ops.addLast(c);
            }else if(c == ')'){
                while(!ops.isEmpty()){
                    if(ops.peekLast() == '('){
                        ops.pollLast();
                        break;
                    }else{
                        calc(nums,ops);
                    }
                }
            }else{
                if(c >= '0' && c <= '9'){
                    int u = 0 , j = i ;
                    while(j < n && cs[j] >= '0' && cs[j]<='9'){
                        u = u*10 + (cs[j++]-'0');
                    }
                    nums.addLast(u);
                    i = j - 1 ;
                }else{
                    if(i > 0 && (cs[i-1]=='(' || cs[i-1]=='-'||cs[i-1]=='+')){
                        nums.addLast(0);
                    }
                    while(!ops.isEmpty()&&ops.peekLast()!='('){
                        char prev = ops.peekLast();
                        if(map.get(prev) >= map.get(c)){
                            calc(nums,ops);
                        }else{break;}
                    }
                    ops.addLast(c);
                }
            }
        }
        while(!ops.isEmpty() && ops.peekLast()!='(') {
            calc(nums,ops);
        }
        return nums.peekLast();
    }
    public void calc(Deque<Integer> nums ,Deque<Character> ops){
        if(nums.isEmpty()||nums.size()<2) {
            return;
        }
        if(ops.isEmpty()) {
            return;
        }
        int b = nums.pollLast(),a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0 ;
        if(op == '+'){
            ans = a + b ;
        }else if (op == '-'){
            ans = a - b ;
        }else if(op == '*'){
            ans = a * b ;
        }
        nums.addLast(ans);
    }
    @Test
    public void test(){
        System.out.println(solve("-1+1"));
    }
}
