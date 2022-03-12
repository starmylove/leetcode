package medium;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

public class num_394_2 {
    int ptr = 0 ;
    public String decodeString(String s) {
        LinkedList<String > stk = new LinkedList<>();
        while (ptr < s.length()){
            char cur = s.charAt(ptr);
            if(isDigit(cur)){
                stk.addLast(getDigit(s));
            }else if(isLetter(cur) || cur == '['){
                stk.addLast(String.valueOf(cur));
                ptr ++ ;
            }else {
                ptr ++ ;
                LinkedList<String> sub = new LinkedList<>();
                while (!stk.getLast().equals("[")){
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                stk.removeLast();
                int repTime = Integer.parseInt(stk.removeLast());
                String o = getString(sub);
                StringBuilder t = new StringBuilder();
                for (int i = 0; i < repTime; i++) {
                    t.append(o);
                }
                stk.addLast(t.toString());
            }
        }
        return getString(stk);
    }
    private String getString(LinkedList<String> sub) {
        StringBuilder sb = new StringBuilder();
        while (!sub.isEmpty()){
            sb.append(sub.pollFirst());
        }
        return sb.toString();
    }

    private String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (isDigit(s.charAt(ptr))){
            sb.append(s.charAt(ptr++));
        }
        return sb.toString();
    }

    private boolean isLetter(char cur) {
        return 'a' <= cur && 'z' >= cur;
    }

    private boolean isDigit(char cur) {
        return '0' <= cur && '9' >= cur;
    }
    @Test
    public void test(){
        System.out.println(decodeString("30[p]2[bc]"));
    }
}
