package middle;

import java.util.Arrays;

public class Offer_48 {
    public int lengthOfLongestSubstring(String _s) {
        char[] s = _s.toCharArray();
        int max = 0 ;
        int[] index = new int[128];
        Arrays.fill(index,-1);
        int l = 0 , r = 0 ;
        for( ; r < s.length ; r ++){
            if(index[s[r]-' '] != -1){
                int temp = index[s[r]-' '] + 1;
                for(int j = l ; j <= index[s[r]-' '] ; j ++){
                    index[s[j]-' '] = -1 ;
                }
                l = temp ;
            }
            index[s[r]-' '] = r ;
            max = Math.max(max,r - l + 1);
        }
        return max ;
    }
}
