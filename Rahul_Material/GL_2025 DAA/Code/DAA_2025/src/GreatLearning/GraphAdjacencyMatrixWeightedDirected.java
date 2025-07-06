package GreatLearning;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays; // For Arrays.fill()

public class GraphAdjacencyMatrixWeightedDirected {
    private int numVertices;
    private int[][] matrix; // Stores weights, use Integer.MAX_VALUE for no edge

    public GraphAdjacencyMatrixWeightedDirected(int numVertices) {
        this.numVertices = numVertices;
        this.matrix = new int[numVertices][numVertices];
        // Initialize all cells to "infinity" (no edge)
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
            matrix[i][i] = 0; // Cost to self is 0
        }
       // this.printGraph();
    }

    public void addEdge(int u, int v, int weight) {
        // Directed edge from u to v
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            matrix[u][v] = weight;
            matrix[v][u] = weight;
        } else {
            System.out.println("Invalid vertex indices.");
        }
    }

    public void removeEdge(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            matrix[u][v] = Integer.MAX_VALUE;
        } else {
            System.out.println("Invalid vertex indices.");
        }
    }

    public int getEdgeWeight(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            return matrix[u][v];
        }
        return Integer.MAX_VALUE; // No edge or invalid indices
    }

    // A simple Pair class to hold neighbor and weight
    public static class WeightedEdge {
        public int neighbor;
        public int weight;

        public WeightedEdge(int neighbor, int weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + neighbor + ", " + weight + ")";
        }
    }

    public List<WeightedEdge> getNeighbors(int u) {
        List<WeightedEdge> neighbors = new ArrayList<>();
        if (u >= 0 && u < numVertices) {
            for (int v = 0; v < numVertices; v++) {
                if (matrix[u][v] != Integer.MAX_VALUE && matrix[u][v] != 0) { // Exclude no-edge and self-loops (if they are 0)
                    neighbors.add(new WeightedEdge(v, matrix[u][v]));
                }
            }
        }
        return neighbors;
    }

    public void printGraph() {
        System.out.println("Adjacency Matrix (Weighted, Directed):");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(String.format("%3d ", matrix[i][j])); // Format for alignment
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("\n--- Weighted and Directed Graph (Adjacency Matrix) ---");
        GraphAdjacencyMatrixWeightedDirected g = new GraphAdjacencyMatrixWeightedDirected(3); // 3 vertices (0, 1, 2)

        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 5);
        g.addEdge(1, 2, 3);
        g.printGraph();

//        System.out.println("Weight of edge (0, 1): " + g.getEdgeWeight(0, 1)); // 10
//        System.out.println("Weight of edge (1, 0): " + g.getEdgeWeight(1, 0)); // 2147483647 (Integer.MAX_VALUE for INF)
//        System.out.println("Neighbors of vertex 0: " + g.getNeighbors(0)); // [(1, 10), (2, 5)]
//
//        g.removeEdge(0, 1);
//        System.out.println("\nAfter removing edge (0, 1):");
//        g.printGraph();
//        System.out.println("Weight of edge (0, 1): " + g.getEdgeWeight(0, 1)); // Integer.MAX_VALUE
    }
}
