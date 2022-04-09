package hard;

import org.junit.Test;

public class test {
    int n;

    public int solution(int n, int m, int k, int s,
                        int[][] singleDir, int[][] doubleDir,
                        int a, int b, int q, int[] targets) {
        this.n = n;
        int[][] graph = new int[n][n];
        for (int i = 0; i < m; i++) {
            int src = singleDir[i][0] - 1;
            int target = singleDir[i][1] - 1;
            int cost = singleDir[i][2];
            if (src == target
                    || (graph[src][target] != 0
                    && graph[src][target] < cost)) {
                continue;
            }
            graph[src][target] = cost;
        }
        for (int i = 0; i < k; i++) {
            int x = doubleDir[i][0] - 1;
            int y = doubleDir[i][1] - 1;
            int cost = doubleDir[i][2];
            if (x == y) {
                continue;
            }
            if (graph[x][y] == 0 || graph[x][y] > cost) {
                graph[x][y] = cost;
            }
            if (graph[y][x] == 0 || graph[y][x] > cost) {
                graph[y][x] = cost;
            }
        }
        int[][] dists = new int[n][n];
        for (int i = 0; i < n; i++) {
            dists[i] = dijkstra(graph, i);
        }
        int time = 0;
        int cur = s - 1;
        for (int i = 0; i < q; i++) {
            int target = targets[i] - 1;
            time += dists[cur][target];
            if ((time & 1) == 1) {
                time += a;
            } else {
                time += b;
            }
            cur = target;
        }
        time += dists[cur][s - 1];
        return time;
    }

    int[] dijkstra(int[][] graph, int src) {
        int dist[] = new int[n];
        boolean set[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            set[i] = false;
        }
        dist[src] = 0;
        for (int c = 0; c < n - 1; c++) {
            int u = minDist(dist, set);
            set[u] = true;
            for (int v = 0; v < n; v++) {
                if (!set[v] && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }

    int minDist(int[] dist, boolean[] set) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int r = 0; r < n; r++) {
            if (set[r] == false && dist[r] <= min) {
                min = dist[r];
                minIndex = r;
            }
        }
        return minIndex;
    }
    @Test
    public void test() {
        int solution = solution(6, 4, 4, 2, new int[][]{{1, 2, 1}, {4, 1, 2}, {3, 5, 2}, {2, 3, 1}}, new int[][]{{6, 3, 1}, {4, 5, 1}, {1, 3, 3}, {2, 4, 2}}, 2, 3, 5, new int[]{1, 4, 6, 6, 2});
        System.out.println(solution);
    }
}