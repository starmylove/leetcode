package middle;
import java.util.HashMap;
import java.util.Map;
public class Offer_67 {
    public int strToInt(String str) {
        int n = str.length();
        int index = 0 ;
        while (index < n && str.charAt(index) ==' ') {
            index++;
        }
        if(index == n) {
            return 0;
        }
        if(str.charAt(index) != '+' && str.charAt(index) != '-'
                && str.charAt(index) > '9' && str.charAt(index) < '0') {
            return 0;
        }
        boolean rev = false ;
        if(str.charAt(index) == '+') {
            index++;
        } else if(str.charAt(index) == '-') {
            rev = true;
            index++;
        }
        if(index == n || str.charAt(index) > '9' || str.charAt(index) < '0') {
            return 0;
        }
        while (index < n && str.charAt(index) == '0') {
            index++;
        }
        if(index == n || str.charAt(index) > '9' || str.charAt(index) < '1') {
            return 0 ;
        }
        long ans = 0 ;
        while (index < n && (str.charAt(index) <= '9' && str.charAt(index) >= '0')){
            if(ans == 0) {
                ans -= str.charAt(index) - '0' ;
            } else {
                ans *= 10 ;
                ans -= str.charAt(index) - '0' ;
            }
            if(ans <= Integer.MIN_VALUE) {
                return rev?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            index++;
        }
        return rev?(int) ans:-(int)ans;
    }
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}
class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};
    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }
    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}

