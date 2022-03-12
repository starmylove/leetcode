package hard;

/**
 * @author 19476
 */
public class num_76 {
    public String minWindow(String s, String t) {
        int l = 0 , r = -1 ;
        int[] cnt1 = new int[128] , cnt2 = new int[128];
        for(int i = 0 ; i < t.length() ; i ++){
            cnt2[t.charAt(i)]++;
        }
        int sum = 0 , target = t.length();
        int L = -1 , R = -1 ,min = Integer.MAX_VALUE;
        for(r = 0 ; r < s.length() ; r ++){
            cnt1[s.charAt(r)]++;
            if(cnt1[s.charAt(r)] <= cnt2[s.charAt(r)]){
                sum ++ ;
                while(sum == target){
                    if(r - l - 1 < min){
                        min = r - l - 1 ;
                        L = l ;
                        R = r ;
                    }
                    if(--cnt1[s.charAt(l)] < cnt2[s.charAt(l)]){
                        sum -- ;
                    }
                    l ++ ;
                }
            }
        }
        if(L < 0){
            return "";
        }
        return s.substring(L,R+1);
    }
}
