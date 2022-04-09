package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(x <= arr[0]){
            return getAns(arr,0,k - 1);
        }
        if(x >= arr[arr.length - 1]) {
            return getAns(arr,arr.length - k,arr.length - 1);
        }
        int index = 0, l = 0, r = arr.length - 1;
        while(l <= r){
            int mid = (l + r) >> 1;
            if(arr[mid] >= x){
                index = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        l = index;
        r = index;
        for(int i = 0; i < k - 1; i ++){
            if(l == 0){
                r = k - 1;
                break;
            }
            if(r == arr.length - 1){
                l = arr.length - k;
                break;
            }
            if(Math.abs(x - arr[l - 1]) > Math.abs(x - arr[r + 1])){
                r ++;
            }else{
                l --;
            }
        }
        return getAns(arr,l,r);
    }

    private List<Integer> getAns(int[] arr, int l, int r) {
        List<Integer> ans = new ArrayList<>();
        for(int i = l; i <= r; i ++){
            ans.add(arr[i]);
        }
        return ans;
    }

    @Test
    public void test(){
        List<Integer> closestElements = findClosestElements(new int[]{-2,-1,1,2,3,4,5}, 7, 3);
        closestElements.forEach(System.out::println);
    }
}
