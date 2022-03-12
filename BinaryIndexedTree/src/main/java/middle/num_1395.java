package middle;

import javafx.scene.media.VideoTrack;
import org.junit.Test;

import java.util.Arrays;

public class num_1395 {
    //1395. 统计作战单位数
    /*
    *  n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
每 3 个士兵可以组成一个作战单位，分组规则如下：
    从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
    作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
    * */
    int[] leftLess , leftMore ; // leftLess[i]代表rating[i]的左侧有几个比他小的数，其他三个数组同理
    int[] rightLess , rightMore ;
    int[] a, c ;
    public int numTeams(int[] rating) {
        int n = rating.length ;
        init(rating);
        for (int i = n - 1; i >= 0 ; i--) {
            int id = getId(rating[i]);
            rightLess[i] = query(id);
            rightMore[i] = n - 1 - i - rightLess[i] ;
            update(id);
        }
        c = new int[n+1];
        for (int i = 0; i < n ; i++) {
            int id = getId(rating[i]);
            leftLess[i] = query(id);
            leftMore[i] = i - leftLess[i] ;
            update(id);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += leftLess[i] * rightMore[i] + leftMore[i] * rightLess[i];
        }
        return ans;
    }
    int getId(int x){
        return Arrays.binarySearch(a,x)+1;
    }
    private void init(int[] rating) {
        int n = rating.length ;
        leftMore = new int[n];
        leftLess = new int[n];
        rightMore = new int[n];
        rightLess = new int[n];
        a = Arrays.copyOf(rating,n);
        Arrays.sort(a);
        c = new int[a.length+1];
    }
    public void update(int x ){
        while (x < c.length){
            c[x] += 1 ;
            x += lowbit(x);
        }
    }
    public int query(int id){
        int sum = 0 ;
        while (id > 0){
            sum += c[id] ;
            id -= lowbit(id) ;
        }
        return sum ;
    }
    int lowbit(int i){
        return i & -i;
    }
    @Test
    public void test(){
        numTeams(new int[]{2,5,3,4,1});
    }
}
