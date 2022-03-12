package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class num_500 {
    /*
    *
    第一行由字符 "qwertyuiop" 组成。
    第二行由字符 "asdfghjkl" 组成。
    第三行由字符 "zxcvbnm" 组成。

    * */
    public String[] findWords(String[] words) {
        String rowIdx = "12210111011122000010020202";
        List<String> list = new ArrayList<String>();
        for(String s : words){
            boolean isValid = true ;
            char idx = rowIdx.charAt(Character.toLowerCase(s.charAt(0))-'a');
            for (int i = 1; i < s.length(); i++) {
                if(rowIdx.charAt(Character.toLowerCase(s.charAt(i))-'a') != idx){
                    isValid = false ;
                    break;
                }
            }
            if(isValid){
                list.add(s);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}












