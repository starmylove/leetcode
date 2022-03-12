package easy;

import java.util.HashSet;
import java.util.Set;

public class num_575 {

    public int distributeCandies(int[] candyType) {
        int half = candyType.length >> 1;
        int[] types = new int[1 << 13];
        int ans = 0;
        for (int type : candyType) {
            int index = type + 100_000 ;
            if ((types[index >> 5] & 1 << (index & 31)) == 0) {
                ans++;
                if (ans == half) {
                    return ans;
                }
            }
            types[index >> 5] |= 1 << (index & 31);
        }
        return ans;
    }public int distributeCandies1(int[] candyType) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : candyType){
            set.add(num);
        }
        int size = set.size() , n = candyType.length;
        if(size >= n / 2){
            return n/2;
        }
        return size ;
    }
    public int distributeCandies2(int[] candyType) {
        boolean[] map = new boolean[2000001];
        int max = candyType.length / 2;
        int count = 0;
        for (int t : candyType) {
            int index = t + 1000000;
            if (!map[index]) {
                count++;
                map[index] = true;
                if (count >= max) {
                    return max;
                }
            }
        }
        return count;
    }
}
