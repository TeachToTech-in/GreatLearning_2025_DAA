package GreatLearning;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyMatrixUnweighted {
    private int numVertices;
    private int[][] matrix; // 0 for no edge, 1 for edge

    public GraphAdjacencyMatrixUnweighted(int numVertices) {
        this.numVertices = numVertices;
        this.matrix = new int[numVertices][numVertices];
        // By default, int arrays are initialized to 0 in Java
    }

    public void addEdge(int u, int v) {
        // For undirected graph, add edge in both directions
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        } else {
            System.out.println("Invalid vertex indices.");
        }
    }

    public void removeEdge(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            matrix[u][v] = 0;
            matrix[v][u] = 0;
        } else {
            System.out.println("Invalid vertex indices.");
        }
    }

    public boolean hasEdge(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            return matrix[u][v] == 1;
        }
        return false;
    }

    public List<Integer> getNeighbors(int u) {
        List<Integer> neighbors = new ArrayList<>();
        if (u >= 0 && u < numVertices) {
            for (int v = 0; v < numVertices; v++) {
                if (matrix[u][v] == 1) {
                    neighbors.add(v);
                }
            }
        }
        return neighbors;
    }

    public void printGraph() {
        System.out.println("Adjacency Matrix (Unweighted, Undirected):");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Unweighted and Undirected Graph (Adjacency Matrix) ---");
        GraphAdjacencyMatrixUnweighted g = new GraphAdjacencyMatrixUnweighted(4); // 4 vertices (0, 1, 2, 3)
       
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.printGraph();

//        System.out.println("Has edge (0, 1)? " + g.hasEdge(0, 1)); // True
//        System.out.println("Has edge (0, 3)? " + g.hasEdge(0, 3)); // False
//        System.out.println("Neighbors of vertex 2: " + g.getNeighbors(2)); // [0, 1, 3]
//
//        g.removeEdge(0, 1);
//        System.out.println("\nAfter removing edge (0, 1):");
//        g.printGraph();
//        System.out.println("Has edge (0, 1)? " + g.hasEdge(0, 1)); // False
    }
}