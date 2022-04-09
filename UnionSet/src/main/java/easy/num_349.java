package easy;

import org.junit.Test;

import java.util.*;

public class num_349 {
    int[] f, rank;
    public int[] intersection(int[] nums1, int[] nums2) {
        init();
        for (int i = 0; i < nums1.length; i++) {
            union(nums1[i], 1001);
        }
        Set<Integer> ans = new HashSet<>();
        for(int num2 : nums2) {
            if(connect(num2, 1001)){
                ans.add(num2);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public void init(){
        f = new int[1002];
        rank = new int[1002];
        Arrays.fill(rank, 1);
        for (int i = 0; i < 1002; i++) {
            f[i] = i;
        }
    }
    public boolean connect(int x, int y){
        return find(x) == find(y);
    }
    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }
    public boolean union(int x, int y) {
        int fx = find(x), fy = find(y);
        if(fx == fy){
            return false;
        }
        if(rank[fx] < rank[fy]){
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        rank[fx] += rank[fy];
        f[fy] = fx;
        return true;
    }
    @Test
    public void test(){
        System.out.println(intersection(new int[]{61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81}, new int[]{5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48}));
    }
}