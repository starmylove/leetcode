package hard;

public class Takeout {
    int n;
    public int solution(int n, int m, int k, int s, int[][] singleDir, int[][] doubleDir,
                        int a, int b, int q, int[] targets) {
        this.n = n;
        int[][] graph = new int[n][n];
        for(int i = 0; i < m; i ++){
            int src = singleDir[i][0] - 1;
            int target = singleDir[i][1] - 1;
            int cost = singleDir[i][2];
            if (src == target
                    || (graph[src][target] != 0
                    && cost > graph[src][target])) {
                continue;
            }
            graph[src][target] = cost;
        }
        for(int i = 0; i < k; i ++){
            int x = doubleDir[i][0] - 1;
            int y = doubleDir[i][1] - 1;
            int cost = doubleDir[i][2];
            if(x == y){
                continue;
            }
            if(graph[x][y] == 0 || cost < graph[x][y]){
                graph[x][y] = cost;
            }
            if(graph[y][x] == 0 || cost < graph[y][x]){
                graph[y][x] = cost;
            }
        }
        int time = 0;
        int cur = s - 1;
        int[][] dists = new int[n][n];
        for (int i = 0; i < n; i++) {
            dists[i] = dijkstra(graph, i);
        }
        for(int target : targets) {
            time += dists[cur][target];
            if ((time & 1) == 1) {
                time += a;
            } else {
                time += b;
            }
            cur = target;
        }
        return time + dists[cur][s - 1];
    }

    private int[] dijkstra(int[][] graph, int i) {
        return new int[0];
    }
}
