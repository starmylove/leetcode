package easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num_120 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if(a.length() < b.length()){
                return -1;
            }else if(a.length() > b.length()){
                return 1;
            }
            return b.compareTo(a);
        });
        if(words.length == 0 || words[0].length() > 1){
            return "";
        }
        String ans = "";
        Set<String> set = new HashSet<>();
        set.add("");
        for(int i = 0; i < words.length; i ++){
            if(set.contains(words[i].substring(0,words[i].length() - 1))){
                set.add(words[i]);
                ans = words[i];
            }
        }
        return ans;
    }

    @Test
    public void test(){
        String s = longestWord(new String[]{"a","banana","app","appl","ap","apply","apple"});
        System.out.println(s);
    }
}
