package easy;

public class num_338 {
    public int[] countBits(int n) {
        if(n==0) {
            return new int[]{0};
        }
        if(n==1) {
            return new int[]{0,1};
        }
        int[] ans = new int[n+1];
        ans[1] = 1 ;
        int index = 2 , length = 2 ;
        while (true){
            int i;
            for (i = index; i <index+length ; i++) {
                ans[i] = 1 + ans[i-length];
                if(i==n) {
                    return ans;
                }
            }
            index = i ;
            length*=2;
        }
    }
}
