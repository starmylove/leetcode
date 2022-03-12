package easy;

import org.junit.Test;

public class num_434 {
    public int countSegments(String s) {
        char[] chars = s.toCharArray();
        int ans = 0 ;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if(chars[i] != ' ' && (i==0 || chars[i-1]==' ') ) {
                ans++;
            }
        }
        return ans ;
    }
    @Test
    public void test(){
        int i = countSegments("\"The one-hour drama series Westworld is a dark odyssey " +
                "about the dawn of artificial consciousness and the evolution " +
                "of sin. Set at the intersection of the near future and the reimagined past, " +
                "it explores a world in which every human appetite, no matter how noble or depraved, " +
                "can be indulged.");
        System.out.println(i);
    }
}
