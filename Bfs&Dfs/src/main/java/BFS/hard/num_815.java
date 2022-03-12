package BFS.hard;

import org.junit.Test;

import java.util.*;

public class num_815 {
    /*
    * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
    例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
    现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
    求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1
    * */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //官方题解
        if(source==target) {
            return 0;
        }

        int n = routes.length;
        boolean edges[][] = new boolean[n][n];
        Map<Integer,List<Integer>> rec = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site,new ArrayList<Integer>());
                for(int j : list){
                    edges[i][j] = edges[j][i]= true;
                }
                list.add(i);
                rec.put(site,list);
            }
        }
        if(!rec.containsKey(source)) {
            return -1;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] dis = new int[n];
        Arrays.fill(dis,-1);
        for(int bus : rec.getOrDefault(source, new ArrayList<Integer>())){
            deque.addLast(bus);
            dis[bus]=1;
        }
        while(!deque.isEmpty()){
            int x = deque.pollFirst();
            for(int y = 0 ; y < n ; y++){
                if(edges[x][y] && dis[y]==-1){
                    dis[y]=dis[x]+1;
                    deque.addLast(y);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : rec.get(target)){
            if(dis[i]!=-1) {
                min=Math.min(min,dis[i]);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
    public int numBusesToDestination2(int[][] routes, int source, int target) {
        //官方题解-复现
        if(source==target) {
            return 0;
        }
        int n = routes.length;
        int[] dis = new int[n];
        boolean[][] edges = new boolean[n][n];
        Arrays.fill(dis,-1);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        //首先建图
        for (int bus = 0; bus < n; bus++) {
            for (int site : routes[bus]){//
                if(site==source){//若该公交站是起始站，则入队，并且将对应公交车的成本置1
                    dis[bus] = 1 ;
                    deque.addLast(bus);
                }
                //对于每一个公交站，维护一个列表，用于存放所有经过该公交站的公交车的编号
                List<Integer> list = map.getOrDefault(site,new ArrayList<>());
                for(int buses_from_site : list ) {
                    edges[buses_from_site][bus] = edges[bus][buses_from_site] = true;//表示公交车bus可换乘至公交车buses_from_site
                }
                list.add(bus);
                map.put(site,list);
            }
        }
        //OK现在已经有了所有起始站点上经过的bus，都存放在deque里
        //接下来开始层次遍历
        while(!deque.isEmpty()){
            int poll = deque.pollFirst();
            //对于出队的每个公交车，换乘至他能换成的且dis为-1的公交车
            for (int i = 0; i < n; i++) {
                if(edges[poll][i]&&dis[i]==-1){
                    dis[i] = dis[poll]+1;
                    deque.addLast(i);
                }
            }
        }
        if(!map.containsKey(target)) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for(int bus : map.get(target)){
            if(dis[bus]!=-1){
                min = Math.min(min,dis[bus]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public int numBusesToDestination1(int[][] routes, int source, int target) {
        //宫水三叶
        if(source==target) {
            return 0;
        }
        //建图的过程中初始化队列，将经过source的公交路线入队
        Deque<Integer> deque = new ArrayDeque<>();
        //key是公交站点，value是经过该公交站点的公交车（用在routes数组中的下标表示）的集合
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int n = routes.length;
        //key是公交车，value用于存放从source出发到达该公交车所需乘坐几辆车
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for(int site : routes[i]){
                if(site==source){
                    deque.addLast(i);
                    m.put(i,1);
                }
                Set<Integer> set = map.getOrDefault(site,new HashSet<>());
                set.add(i);
                map.put(site,set);
            }
        }
        while(!deque.isEmpty()){
            //从队列里取出一个公交车
            int poll = deque.pollFirst();
            //查看该公交车目前换乘了几次了
            int step = m.get(poll);
            //下面依次遍历从该公交车所能到达的车站
            for(int site : routes[poll]){
                //若当前公交车能到达终点，返回结果
                if(site==target) {
                    return step;
                }
                //对于每一个当前公交车能到达的车站，所有经过该车站的公交车，没访问过的，都入队
                Set<Integer> buses = map.get(site);
                for(Integer bus : buses){
                    if(!m.containsKey(bus)){
                        m.put(bus,step+1);
                        deque.addLast(bus);
                    }
                }
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int i = numBusesToDestination2(new int[][]{{1,2,7},{3,6,7}}, 1, 6);
        System.out.println(i);
    }

}
