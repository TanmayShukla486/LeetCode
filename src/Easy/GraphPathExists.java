package Easy;

import java.util.ArrayList;
import java.util.List;

public class GraphPathExists {
    private boolean dfs(int src, List<List<Integer>> adjList, boolean[] visited, int dest) {
        // If the source node is the destination, return true
        if (src == dest) return true;

        // Mark the current node as visited
        visited[src] = true;

        // Explore all adjacent nodes of the current node
        for (int adjacent : adjList.get(src)) {
            // If the adjacent node is not visited, recursively call dfs on it
            if (!visited[adjacent]) {
                if (dfs(adjacent, adjList, visited, dest)) return true;
            }
        }

        // If destination is not found in the adjacent nodes, return false
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Initialize an array to keep track of visited nodes
        boolean[] visited = new boolean[n];

        // Create an adjacency list to represent the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        // Populate the adjacency list with edges
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]); // For undirected graph
        }

        // Call the dfs method to find if there is a valid path from source to destination
        return dfs(source, adjList, visited, destination);
    }

}
