package GreatLearning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphAdjacencyListUnweighted {
	private int numVertices;
	private ArrayList<ArrayList<Integer>> adjList; // List of lists to store neighbors

	public GraphAdjacencyListUnweighted(int numVertices) {
		this.numVertices = numVertices;
		adjList = new ArrayList<>(numVertices);
		for (int i = 0; i < numVertices; i++) {
			adjList.add(new ArrayList<>()); // Initialize an empty list for each vertex
		}
	}

	public void addEdge(int u, int v) {
		// For undirected graph, add edge in both directions
		if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		} else {
			System.out.println("Invalid vertex indices.");
		}
	}

	public void removeEdge(int u, int v) {
		if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
			adjList.get(u).remove(Integer.valueOf(v)); // Use Integer.valueOf to remove by object, not index
			adjList.get(v).remove(Integer.valueOf(u));
		} else {
			System.out.println("Invalid vertex indices.");
		}
	}

	public boolean hasEdge(int u, int v) {
		if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
			return adjList.get(u).contains(v);
		}
		return false;
	}

	public List<Integer> getNeighbors(int u) {
		if (u >= 0 && u < numVertices) {
			return adjList.get(u);
		}
		return new ArrayList<>(); // Return empty list for invalid vertex
	}

	public void printGraph() {
		System.out.println("Adjacency List (Unweighted, Undirected):");
		for (int i = 0; i < numVertices; i++) {
			System.out.print("Vertex " + i + ": ");
			for (Integer neighbor : adjList.get(i)) {
				System.out.print(neighbor + " ");
			}
			System.out.println();
		}
	}

	public ArrayList<Integer> bfsOfGraph(int start, int V, ArrayList<ArrayList<Integer>> adj) {

		ArrayList<Integer> bfs = new ArrayList<>();
		boolean vis[] = new boolean[V];
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		vis[start] = true;

		while (!q.isEmpty()) {
			Integer node = q.poll();
			bfs.add(node);

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			for (Integer it : adj.get(node)) {
				if (vis[it] == false) {
					vis[it] = true;
					q.add(it);
				}
			}
		}

		return bfs;
	}

	public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {

		// marking current node as visited
		vis[node] = true;
		ls.add(node);

		// getting neighbour nodes
		for (Integer it : adj.get(node)) {
			if (vis[it] == false) {
				dfs(it, vis, adj, ls);
			}
		}
	}

	public ArrayList<Integer> dfsOfGraph(int start, int V, ArrayList<ArrayList<Integer>> adj) {
		// boolean array to keep track of visited vertices
		boolean vis[] = new boolean[V];
		vis[start] = true;
		ArrayList<Integer> ls = new ArrayList<>();
		dfs(start, vis, adj, ls);
		return ls;
	}

	public static void main(String[] args) {
		System.out.println("\n--- Unweighted and Undirected Graph (Adjacency List) ---");
		GraphAdjacencyListUnweighted g = new GraphAdjacencyListUnweighted(5); // 4 vertices (0, 1, 2, 3)

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.printGraph();
// BFS CALL with  (Starting Vertex , Number of Nodes Starting With Zero Indexing, Adjacency List)
 //       System.out.println(g.bfsOfGraph(3,g.adjList.size(), g.adjList));
// DFS CALL with (Starting Vertex , Number of Nodes Starting With Zero Indexing, Adjacency List)

	System.out.println(g.dfsOfGraph(4, 5, g.adjList));
//        System.out.println("Has edge (0, 1)? " + g.hasEdge(0, 1)); // True
//        System.out.println("Has edge (0, 3)? " + g.hasEdge(0, 3)); // False
//        System.out.println("Neighbors of vertex 2: " + g.getNeighbors(2)); // [0, 1, 3]
//
//        g.removeEdge(0, 1);
//        System.out.println("\nAfter removing edge (0, 1):");
//		g.printGraph();
//        System.out.println("Has edge (0, 1)? " + g.hasEdge(0, 1)); // False
	}
}