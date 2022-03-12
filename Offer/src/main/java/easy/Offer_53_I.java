package easy;

public class Offer_53_I {
    public int search(int[] nums, int target) {
        int ans = 0 ;
        for(int i : nums){
            if(i == target){
                ans ++;
            }
            else if(i > target) {
                return ans;
            }
        }
        return ans;
    }
}
