package medium;

public class num_1514_2 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end){
        double[] dist = new double[n];
        double[][] graph = new double[n][n];
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = succProb[i];
            graph[edges[i][1]][edges[i][0]] = succProb[i];
        }
        boolean[] set = new boolean[n];
        dist[start] = 1;
        for (int i = 0; i < n - 1; i++) {
            double max = 0;
            int maxIndex = 0;
            for (int j = 0; j < n; j++) {
                if(!set[j] && dist[j] > max){
                    max = dist[j];
                    maxIndex = j;
                }
            }
            set[maxIndex] = true;

            for (int j = 0; j < n; j++) {
                if(!set[j] && graph[maxIndex][j] != 0 && graph[maxIndex][j] * dist[maxIndex] > dist[j]){
                    dist[j] = graph[maxIndex][j] * dist[maxIndex];
                }
            }
        }
        return dist[end];
    }
}
