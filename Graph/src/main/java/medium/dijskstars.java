package medium;

public class dijskstars {
    int[] minPath(int[][] edges, int src){
        int[] dist = new int[edges.length];
        boolean[] set = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for (int i = 0; i < edges.length - 1; i++) {
            int minIndex = 0, min = Integer.MAX_VALUE;
            for (int j = 0; j < edges.length; j++) {
                if(!set[j] && min > edges[src][j]){
                    min = edges[src][j];
                    minIndex = j;
                }
            }
            set[minIndex] = true;
            for (int j = 0; j < edges.length; j++) {
                if(!set[j] && edges[minIndex][j] != Integer.MAX_VALUE && dist[minIndex] + edges[minIndex][j] < dist[j]){
                    dist[j] = edges[minIndex][j] + dist[minIndex];
                }
            }
        }
        return dist;
    }
}
