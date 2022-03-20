package DFS.hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    List<Node> nodes = new ArrayList<>();
    int ans = Integer.MAX_VALUE, n;
    boolean[] visited;
    int pathLen = 0;
    public int solution(int m, int n, int[][] nums){
        for (int i = 1; i <= n; i++) {
            nodes.add(new Node(i));
        }
        this.n = n;
        visited = new boolean[n];
        for(int i = 0; i < m; i++){
            nodes.get(nums[i][0] - 1).nebs.put(nums[i][1], nums[i][2]);
            nodes.get(nums[i][1] - 1).nebs.put(nums[i][0], nums[i][2]);
        }
        for (int i = 1; i <= n; i++) {
            dfs(i, 0);
        }
        return ans;
    }
    public void dfs(int index, int max){
        if(pathLen == n - 1){
            ans = Math.min(ans, max);
            return;
        }
        pathLen ++;
        visited[index - 1] = true;

        for(int neb : nodes.get(index - 1).nebs.keySet()){
            if(!visited[neb - 1]){
                dfs(neb, Math.max(max, nodes.get(index - 1).nebs.get(neb)));
            }
        }
        pathLen --;
        visited[index - 1] = false;
    }
    class Node{
        public Node(int index){
            this.index = index;
        }
        int index;
        Map<Integer, Integer> nebs = new HashMap<>();
    }

    @Test
    public void test(){
        System.out.println(solution(3, 3, new int[][]{{1, 2, 3}, {1, 3, 4}, {2, 3, 5}}));
    }
    public int solution1(int a, int b, int c, int d){
        int count  = b * d, ans = 0;
        while(count > 0){
            ans += 1;
            count -= a;
            if(count <= 0){
                return ans;
            }
            if((count % b) > 0){
                a -= ((count / b) + 1) * c;
            }else {
                a -= (count / b) * c;
            }
            if(a <= 0){
                return -1;
            }
        }
        return -1;
    }
    public int solution2(int a,int b,int c,int d){
        List<Integer> bunker=new ArrayList<>();
        for (int i=0;i<d;i++)bunker.add(b);
        helper(a,bunker,c);
        return this.ans;
    }

    public void helper(int a,List<Integer> bunker,int c){
        if (a<=0&&bunker.size()>0){
            this.ans=-1;
            return;
        }
        if (bunker.size()==0&&a>=0)return;
        this.ans++;
        int min=bunker.get(bunker.size()-1);
        if (a>=min){
            bunker.remove(bunker.size()-1);
            if (bunker.size()==0)return;
            else {
                int k = bunker.get(bunker.size() - 1) - a + min;
                bunker.set(bunker.get(bunker.size() - 1), k);
            }

        }
        else {
            int k=bunker.get(bunker.size()-1)-a;
            bunker.remove(bunker.get(bunker.size()-1));
            bunker.add(k);
        }
        a-=bunker.size()*c;

        helper(a,bunker,c);
    }
    @Test
    public void test1(){
        System.out.println(solution1(10, 6, 8, 2));
    }
}