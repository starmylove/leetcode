package easy;

import org.junit.Test;

public class Offer_58_I {
    public String reverseWords(String _s) {
        if(_s.length()==0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] s = _s.toCharArray();
        for (int i = s.length-1; i >= 0 ; i--) {
            if(s[i] == ' '){
                if(sb.length()>0 && sb.charAt(sb.length()-1)!=' ') {
                    sb.append(' ');
                }
            }else {
                int r = i , l = i;
                while (l >= 0 && s[l] != ' '){
                    l -- ;
                }
                for (int j = l + 1; j <= r; j++) {
                    sb.append(s[j]);
                }
                i = l + 1;
            }
        }
        if(sb.length()>0) {
            while (sb.charAt(sb.length()-1) == ' ') {
                sb.replace(sb.length() - 1, sb.length(), "");
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        reverseWords("Hello World ");
    }
}
