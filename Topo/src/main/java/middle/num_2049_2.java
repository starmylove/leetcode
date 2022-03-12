package middle;

import org.junit.Test;

import java.util.*;

public class num_2049_2 {
    int cnt = 0, n;
    List<Integer>[] children;
    long maxScore = 0;
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parents[i]].add(i);
        }
        dfs(0);
        return cnt;
    }
    public int dfs(int node){
        long score = 1;
        int size = n - 1;
        for(int child : children[node]){
            int t = dfs(child);
            score *= t;
            size -= t;
        }
        if(node != 0){
            score *= size;
        }
        if(score == maxScore){
            cnt ++;
        }else if(score > maxScore){
            maxScore = score;
            cnt = 1;
        }
        return n - size;
    }

    //给二熊帮忙做微软笔试题
    public int minimum(int[] a){
        int n = a.length;
        Set<Integer> set = new HashSet<>();
        for (int i : a){
            set.add(i);
        }
        int len = set.size(), index = 0;
        int[] cnt = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : set){
            map.put(i, index);
            index ++;
        }
        int l = 0, r, sum = 0;
        int L = -1 ,R = -1, min = Integer.MAX_VALUE;
        for(r = 0 ; r < n ; r ++){
            //更新当前窗口location计数器
            cnt[map.get(a[r])]++;
            //加入了稀缺元素
            if(cnt[map.get(a[r])] <= 1){
                sum ++ ;
                while(sum == len){
                    if(r - l + 1 < min){
                        //更新答案
                        min = r - l + 1 ;
                        L = l ;
                        R = r;
                    }
                    //如果左移导致当前窗口不再能够覆盖所有location，则更新
                    if(--cnt[map.get(a[l])] < 1){
                        sum -- ;
                    }
                    //窗口左移
                    l ++ ;
                }
            }
        }
        return R - L + 1;
    }
    @Test
    public void test(){
        int minimum = minimum(new int[]{7,5,2,7,2,7,4,7});
        System.out.println(minimum);
    }
}