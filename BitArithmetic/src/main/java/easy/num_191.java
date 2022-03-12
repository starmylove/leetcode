package easy;

public class num_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans=0;
        for(int i = 0 ; i < 32 ; i++){
            if((n>>i&1)==1) {
                ans++;
            }
        }
        return ans;
    }
    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int ans=0;
        while(n!=0){
            n &=n-1;
            ans++;
        }
        return ans;
    }
}
