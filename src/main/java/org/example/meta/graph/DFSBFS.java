package org.example.meta.graph;

import java.util.*;

public class DFSBFS {

    static class Edge {
        int source, dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    static class Graph {
        List<List<Integer>> adjList = new ArrayList<>();

        public Graph(List<Edge> edges, int n) {
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (Edge edge : edges) {
                int source = edge.source;
                int dest = edge.dest;

                adjList.get(source).add(dest);
                adjList.get(dest).add(source);
            }
        }
    }

    public static void DFS(Graph graph, int v, boolean[] discovered) {
        discovered[v] = true;
        System.out.print(v + " ");

        for (int u : graph.adjList.get(v)) {
            if (!discovered[u]) {
                DFS(graph, u, discovered);
            }
        }
    }

    public static void BFS(Graph graph, int v, boolean[] discovered) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
        discovered[v] = true;
        while(!q.isEmpty()){
            int i = q.poll();
            System.out.print(i + " ");
            for (int u : graph.adjList.get(v)) {
                if (!discovered[u]) {
                    discovered[u] = true;
                    BFS(graph, u, discovered);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                // Notice that node 0 is unconnected
                new Edge(1, 2), new Edge(1, 7), new Edge(1, 8), new Edge(2, 3),
                new Edge(2, 6), new Edge(3, 4), new Edge(3, 5), new Edge(8, 9),
                new Edge(8, 12), new Edge(9, 10), new Edge(9, 11)
        );

        int n = 13;
        Graph graph = new Graph(edges, n);
        boolean[] discovered = new boolean[n];
        System.out.println("DFS Traversal.... ");
        for (int i = 0; i < n; i++) {
            if (!discovered[i]) {
                DFS(graph, i, discovered);
            }
        }

        discovered = new boolean[n];
        System.out.println();
        System.out.println("BFS Traversal.... ");
        for (int i = 0; i < n; i++) {
            if (!discovered[i]) {
                BFS(graph, i, discovered);
            }
        }
    }
}
