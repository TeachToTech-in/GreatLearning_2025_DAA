package GreatLearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijikstra {
	 // This is the missing helper method that needs to be inside the Solution class
    private ArrayList<ArrayList<ArrayList<Integer>>> constructAdj(int[][] edges, int V) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0]; // Source node
            int v = edge[1]; // Destination node
            int weight = edge[2]; // Weight of the edge

            // For a directed graph:
            adj.get(u).add(new ArrayList<>(Arrays.asList(v, weight)));
            // If the graph is undirected, uncomment the line below:
            // adj.get(v).add(new ArrayList<>(Arrays.asList(u, weight)));
        }
        return adj;
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
    // Create adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = constructAdj(edges, V); // Now constructAdj is visible

        // PriorityQueue to store vertices to be processed
        // Each element is a pair: [distance, node]
        PriorityQueue<ArrayList<Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));

        // Create a distance array and initialize all distances as infinite
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Insert source with distance 0
        dist[src] = 0;
        ArrayList<Integer> start = new ArrayList<>();

        start.add(0);
        start.add(src);
        pq.offer(start);

        // Loop until the priority queue is empty
        while (!pq.isEmpty()) {

            // Get the node with the minimum distance
            ArrayList<Integer> curr = pq.poll();
            int d = curr.get(0);
            int u = curr.get(1);

            // Optimization: If we've already found a shorter path to 'u', skip this entry.
            if (d > dist[u]) {
                continue;
            }

            // Traverse all adjacent vertices of the current node
            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int weight = neighbor.get(1);

                // If there is a shorter path to v through u
                if (dist[v] > dist[u] + weight) {
                    // Update distance of v
                    dist[v] = dist[u] + weight;

                    // Add updated pair to the queue
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(dist[v]);
                    temp.add(v);
                    pq.offer(temp);
                }
            }
        }

        // Return the shortest distance array
        return dist;    
    }	
}
