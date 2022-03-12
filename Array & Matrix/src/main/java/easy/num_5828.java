package easy;

import org.junit.Test;

public class num_5828 {
    public boolean isPrefixString(String s, String[] words) {
        int index = 0 ;
        for (int i = 0; index < s.length()&& i < words.length; i++) {
            String str = words[i];
            int j = 0 ;
            while (index < s.length() && j < str.length()){
                if(s.charAt(index)!=str.charAt(j)) {
                    return false;
                }
                index++;
                j++;
            }
            if(index == s.length() && j < str.length()) {
                return false;
            }
        }
        if(index == s.length()) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test(){
        String s = "iloveleetcode";
        String[] words = new String[]{"i","love","leetcode","apples"};
        boolean prefixString = isPrefixString(s, words);
        System.out.println(prefixString);
    }
}
