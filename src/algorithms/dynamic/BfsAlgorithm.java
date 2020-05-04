/*
 * Copyright (c) 2018. All rights Reserved By Krishnakanth Yachareni
 */

package algorithms.dynamic;

import java.util.LinkedList;
import java.util.Queue;

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}

class Graph {
    private final int MAX_VERTS;
    private int nVertices;
    private Vertex vertexList[];
    private int[][] adjMatrix;
    private Queue<Integer> queue;

    public Graph(int maxVertices) {
        MAX_VERTS = maxVertices;
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        queue = new LinkedList<>();
    }

    public void addVertex(char label) {
        vertexList[nVertices++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnVisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
    }

    private int getAdjUnVisitedVertex(int v) {
        for (int j = 0; j < nVertices; j++) {
            if (adjMatrix[v][j] == 1 && !vertexList[j].wasVisited) {
                return j;
            }
        }
        return -1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
    }

    public void displayMatrix() {
        System.out.print("    ");
        for (Vertex v : vertexList) {
            System.out.print(v.label + " ");
        }
        System.out.println();
        for (int i = 0; i < MAX_VERTS; i++) {
            System.out.print(vertexList[i].label + " : ");
            for (int j = 0; j < MAX_VERTS; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("BFS Visits: ");
    }
}

public class BfsAlgorithm {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(1, 4);

        graph.displayMatrix();

        graph.dfs();
    }
}
