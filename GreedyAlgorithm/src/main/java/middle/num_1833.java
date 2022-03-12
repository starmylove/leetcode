package middle;

import java.util.Arrays;
import java.util.PriorityQueue;

public class num_1833 {
    //1833. 雪糕的最大数量
    /*
    * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
    * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，
    * 其中 costs[i] 表示第 i 支雪糕的现金价格。
    * Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
    * 给你价格数组 costs 和现金量 coins ，
    * 请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
    * 注意：Tony 可以按任意顺序购买雪糕。
    * */

    //用大顶堆维护已买了的雪糕价钱，
    // 遍历costs
    //      如果金额没超，插入堆
    //      如果金额超了，那就和堆顶元素比较，替换一个小的

    public int maxIceCream1(int[] costs, int coins) {
        int res = 0, sum = 0;
        // 定义一个大顶堆，优先队列的底层原理就是一个堆排序哦
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        // 遍历所有价格
        for(int cur : costs) {
            if(sum + cur <= coins) {
                // 如果加上当前金额也不会超，那就直接加
                q.offer(cur);
                sum += cur;
                res ++;
            } else if(sum > 0 && cur < q.peek()){
                // 如果加上当前金额会超，那就和堆顶比较，替换一个小的
                sum -= q.poll();
                sum += cur;
                q.offer(cur);
            }
        }
        return res;
    }


    //最简单的方法，先排序，然后从左到右遍历数组，直至coins不足以购买当前雪糕
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        for (  ; i < costs.length && costs[i] <= coins  ; i ++) {
            coins -= costs[i];
        }
        return i;
    }
}













