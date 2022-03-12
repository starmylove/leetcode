package medium;

import java.util.ArrayList;
import java.util.List;

public class num_438 {
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] target = new int[26];
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a'] ++ ;
        }
        int l = 0 , r = p.length() - 1  , n = p.length() ;
        for (int i = 0; i < n - 1 ; i++) {
            cnt[s.charAt(i) - 'a'] ++ ;
        }
        do{
            cnt[s.charAt(r)-'a'] ++ ;
            if(target[s.charAt(r++) - 'a'] != 0 &&canMatch(cnt,target)){
                ans.add(l);
            }
            cnt[s.charAt(l++) - 'a'] -- ;
        }while (r < s.length());
        return ans ;
    }
    public boolean canMatch(int[] cnt , int[] target){
        for (int i = 0; i < 26; i++) {
            if(cnt[i] != target[i]){
                return false;
            }
        }
        return true ;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] target = new int[26];
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a'] ++ ;
        }
        int l = 0 , r = p.length() - 1  , n = p.length() ;
        if(s.length() < n){
            return ans  ;
        }
        int validLen = 0 ;
        for (int i = 0; i < n - 1 ; i++) {
            char c = s.charAt(i) ;
            if(++ cnt[c - 'a'] <= target[c - 'a']){
                validLen ++ ;
            }
        }
        do{
            char c = s.charAt(r++) ;
            if(++ cnt[c - 'a'] <= target[c - 'a']){
                validLen ++ ;
            }
            if(validLen == n){
                ans.add(l);
            }
            c = s.charAt(l++) ;
            if(-- cnt[c - 'a'] < target[c - 'a'] ){
                validLen -- ;
            }
        }while (r < s.length());
        return ans ;
    }
}
