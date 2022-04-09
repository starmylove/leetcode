package medium;

import java.nio.file.Path;
import java.util.*;

public class num_1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i ++) {
            int[] edge = edges[i];
            graph.get(edge[0]).add(new Pair(succProb[i], edge[1]));
            graph.get(edge[1]).add(new Pair(succProb[i], edge[0]));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.offer(new Pair(1, start));
        double[] dist = new double[n];
        dist[start] = 1;
        while(!queue.isEmpty()) {
            Pair poll = queue.poll();
            int node = poll.node;
            double weight = poll.weight;
            if(weight < dist[node]){
                continue;
            }
            for(Pair pair : graph.get(node)){
                int nextNode = pair.node;
                double nextWeight = pair.weight;
                if(dist[node] * nextWeight > dist[nextNode]){
                    queue.offer(new Pair(nextWeight, nextNode));
                    dist[nextNode] = dist[node] * nextWeight;
                }
            }
        }
        return dist[end];
    }
}
class Pair implements Comparable<Pair> {
    double weight;
    int node;
    public Pair(double weight, int node){
        this.weight = weight;
        this.node = node;
    }

    @Override
    public int compareTo(Pair o2) {
        if(this.weight != o2.weight){
            return this.weight - o2.weight > 0 ? -1 : 1;
        }
        return this.node - o2.node;
    }
}
