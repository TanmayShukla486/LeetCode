package Hard;

import java.util.*;

public class IncludedEdges {
    static class Node {
        int val;
        int cost;
        public Node(int val, int cost) {
            this.val = val;
            this.cost = cost;
        }
        public int getCost() {
            return cost;
        }
    }

    // Method to find the shortest path from a source node to all other nodes in the graph
    private void findShortestPath(List<List<Node>> adjList, int source, int[] distance) {
        // Priority queue to store nodes based on their cost (minimum cost first)
        PriorityQueue<Node> cache = new PriorityQueue<>(
                Comparator.comparingInt(Node::getCost)
        );
        // Set initial distance to infinity for all nodes
        int infinity = (int) 1e9;
        Arrays.fill(distance, infinity);
        // Set distance of source node to 0 and add it to the priority queue
        distance[source] = 0;
        cache.add(new Node(source, 0));
        // Dijkstra's algorithm
        while (!cache.isEmpty()) {
            // Extract the node with minimum cost from the priority queue
            Node current = cache.poll();
            // Update distances of adjacent nodes if a shorter path is found
            for (Node adjacentNode : adjList.get(current.val)) {
                int cost = current.cost + adjacentNode.cost;
                if (distance[adjacentNode.val] > cost) {
                    distance[adjacentNode.val] = cost;
                    cache.add(new Node(adjacentNode.val, cost));
                }
            }
        }
    }

    // Method to find whether each edge is included in the shortest path from source to destination
    public boolean[] findAnswer(int n, int[][] edges) {
        // Create adjacency list to represent the graph
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        // Array to store whether each edge is included in the shortest path
        boolean[] edgesIncluded = new boolean[edges.length];
        // Populate adjacency list and initialize arrays to store distances from source and destination
        int[] pathFromSource = new int[n];
        int[] pathToSource = new int[n];
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Node(edge[0], edge[2]));
        }
        // Find the shortest paths from source to all nodes and from destination to all nodes
        findShortestPath(adjList, 0, pathFromSource);
        findShortestPath(adjList, n - 1, pathToSource);
        // Check if each edge is included in the shortest path from source to destination
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            // If the sum of distances from source to u, from destination to v, and edge weight equals the distance from source to destination,
            // mark the edge as included
            if (pathFromSource[u] + pathToSource[v] + wt == pathFromSource[n - 1])
                edgesIncluded[i] = true;
                // If the sum of distances from source to v, from destination to u, and edge weight equals the distance from source to destination,
                // mark the edge as included
            else if (pathFromSource[v] + pathToSource[u] + wt == pathFromSource[n - 1])
                edgesIncluded[i] = true;
        }
        // Return the array indicating whether each edge is included in the shortest path
        return edgesIncluded;
    }

}
