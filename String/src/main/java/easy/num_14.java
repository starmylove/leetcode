package easy;

import org.junit.Test;

public class num_14 {
    //最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE , minIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if(minLen>strs[i].length()) {
                minLen = strs[i].length();
                minIndex = i ;
            }
        }
        if(minLen==0) {
            return "";
        }
        int i ;
        loop:for (i = 0; i < minLen; i++) {
            char c = strs[minIndex].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if(c != strs[j].charAt(i)) {
                    break loop;
                }
            }
        }
        if(i==0) {
            return "";
        } else {
            return strs[minIndex].subSequence(0,i).toString();
        }
    }

    @Test
    public void test(){
        String[] strs = new String[]{"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}
