package hard;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Offer_51 {
    //剑指 Offer 51. 数组中的逆序对
    /*
    * 在数组中的两个数字，如果前面一个数字大于后面的数字，
    * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
    *
    * */
    int[] a , c ;
    public int reversePairs(int[] nums) {
        int n = nums.length ;
        discretization(nums);
        int ans = 0 ;
        c = new int[a.length+1];
        for (int i = n - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            ans += query(id - 1);
            update(id);
        }
        return ans;
    }
    public void update(int x){
        while (x < c.length){
            c[x] ++ ;
            x += lowbit(x);
        }
    }
    private int query(int pos) {
        int sum = 0 ;
        while (pos > 0){
            sum += c[pos] ;
            pos -= lowbit(pos);
        }
        return sum ;
    }
    private int lowbit(int i) {
        return  i & -i;
    }
    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        a = new int[set.size()];
        int index = 0 ;
        for(int num : set){
            a[index++] = num;
        }
        Arrays.sort(a);
    }
    public int getId(int x){
        return Arrays.binarySearch(a,x)+1;
    }
    @Test
    public void test(){
        reversePairs(new int[]{7,5,6,4});
    }
}













