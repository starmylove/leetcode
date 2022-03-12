package medium;

public class num_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0 ;
        }
        int[] cnt = new int[128];
        int max = 0 ;
        char[] chars = s.toCharArray();
        int l = 0 , r = -1 ;
        while(r < s.length()-1){
            if(cnt[chars[++r]-0] == 0){
                cnt[chars[r]-0] = 1 ;
                max = Math.max(max,r+1-l);
            }else{
                while(chars[l] != chars[r]){
                    cnt[chars[l]-0] = 0 ;
                    l++;
                }
                l ++ ;
            }
        }
        return max ;
    }
}
