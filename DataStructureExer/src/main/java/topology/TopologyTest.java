package topology;

import org.junit.Test;

import java.util.*;

public class TopologyTest {
    class Node{
        int num , level ;

        public Node(int num, int level) {
            this.num = num;
            this.level = level;
        }

    }
    PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.level<o2.level) {
                return -1;
            }
            if(o1.level>o2.level) {
                return 1;
            }
            return o1.num - o2.num ;
        }
    });
    private int[] count;
    int[] ans;
    int index = 0 ;
    Comparator cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };
    List<List<Integer>> nodes = new ArrayList<>();
    public int[] coupon(int n , int m , int[][] nums){
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }
        ans = new int[n];
        count = new int[n];
        for (int i = 0; i < m; i++) {
            List<Integer> list = nodes.get(nums[i][0]-1);
            for (int j = 1; j < nums[i].length; j++){
                count[nums[i][j]-1]++;
                list.add(nums[i][j]);
            }
            list.sort(cmp);
        }
        for(int i = 0 ; i < m ; i ++) {
            if(count[i]==0){
                queue.offer(new Node(i+1 , 0 ));
                break;
            }
        }
        bfs();
        return ans;
    }

    private void bfs() {
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            int level = poll.level ;
            ans[index++] = poll.num ;
            List<Integer> node = nodes.get(poll.num-1);
            for (int i = 0; i < nodes.get(poll.num-1).size(); i++) {
                if((--count[node.get(i)-1])==0) {
                    queue.add(new Node(node.get(i),level+1));
                }
            }
        }
    }
    @Test
    public void test(){
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(8);
        arrayList.add(-1);
        arrayList.sort(cmp);
        System.out.println(arrayList);
    }
    @Test
    public void test1(){
        int[][] nums= new int[][]{{6,5,1},{2,4,6},{1,5},{4,3}};
        int[] coupon = coupon(6, 4, nums);
        for (int i = 0; i < coupon.length; i++) {
            System.out.println(coupon[i]);
        }
    }
}
