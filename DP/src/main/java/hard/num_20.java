package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class num_20 {
    /*
    * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。

    * */
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if(stack.isEmpty()) {
                return false;
            } else if(stack.peek().equals(map.get(s.charAt(i)))) {
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.size()!=0) {
            return false;
        }
        return true;
    }
}
