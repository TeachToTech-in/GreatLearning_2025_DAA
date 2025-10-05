package GreatLearning;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects; // For Objects.hash and Objects.equals in WeightedEdge

public class GraphAdjacencyListWeightedDirected {
    private int numVertices;
    private List<List<WeightedEdge>> adjList; // List of lists of WeightedEdge objects

    // A simple Pair class to hold neighbor and weight
    public static class WeightedEdge {
        public int neighbor;
        public int weight;

        public WeightedEdge(int neighbor, int weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }

        // Override equals and hashCode for proper comparison in contains/remove
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WeightedEdge that = (WeightedEdge) o;
            return neighbor == that.neighbor; // Only compare neighbor for equality check
        }

        @Override
        public int hashCode() {
            return Objects.hash(neighbor);
        }

        @Override
        public String toString() {
            return "(" + neighbor + ", " + weight + ")";
        }
    }

    public GraphAdjacencyListWeightedDirected(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>()); // Initialize an empty list for each vertex
        }
    }

    public void addEdge(int u, int v, int weight) {
        // Directed edge from u to v
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            // Check if edge already exists to update weight, or just add
            for (int i = 0; i < adjList.get(u).size(); i++) {
                WeightedEdge existingEdge = adjList.get(u).get(i);
                if (existingEdge.neighbor == v) {
                    existingEdge.weight = weight; // Update weight
                    return;
                }
            }
            adjList.get(u).add(new WeightedEdge(v, weight));
        } else {
            System.out.println("Invalid vertex indices.");
        }
    }

    public void removeEdge(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            // Create a dummy WeightedEdge to use for removal based on neighbor
            adjList.get(u).remove(new WeightedEdge(v, 0)); // Weight doesn't matter for removal with custom equals
        } else {
            System.out.println("Invalid vertex indices.");
        }
    }

    public int getEdgeWeight(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            for (WeightedEdge edge : adjList.get(u)) {
                if (edge.neighbor == v) {
                    return edge.weight;
                }
            }
        }
        return -1; // Or some other indicator for no edge, like Integer.MAX_VALUE
    }

    public List<WeightedEdge> getNeighbors(int u) {
        if (u >= 0 && u < numVertices) {
            return adjList.get(u);
        }
        return new ArrayList<>(); // Return empty list for invalid vertex
    }

    public void printGraph() {
        System.out.println("Adjacency List (Weighted, Directed):");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ": ");
            System.out.println(adjList.get(i));
        }
    }

    public static void main(String[] args) {
        System.out.println("\n--- Weighted and Directed Graph (Adjacency List) ---");
        GraphAdjacencyListWeightedDirected g = new GraphAdjacencyListWeightedDirected(3); // 3 vertices (0, 1, 2)

        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 5);
        g.addEdge(1, 2, 3);
        g.printGraph();

        System.out.println("Weight of edge (0, 1): " + g.getEdgeWeight(0, 1)); // 10
        System.out.println("Weight of edge (1, 0): " + g.getEdgeWeight(1, 0)); // -1 (no edge)
        System.out.println("Neighbors of vertex 0: " + g.getNeighbors(0)); // [(1, 10), (2, 5)]

        g.removeEdge(0, 1);
        System.out.println("\nAfter removing edge (0, 1):");
        g.printGraph();
        System.out.println("Weight of edge (0, 1): " + g.getEdgeWeight(0, 1)); // -1
    }
}