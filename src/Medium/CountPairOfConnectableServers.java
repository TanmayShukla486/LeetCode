package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountPairOfConnectableServers {
    private static class Edge {
        int node, cost;
        public Edge(int destNode, int cost) {
            this.node = destNode;
            this.cost = cost;
        }
    }

    private boolean isPossible(Edge to, int signal) {
        return to.cost % signal == 0;
    }

    int ct = 0;
    private void traverse(List<List<Edge>> adjList, Edge start, boolean[] visited, int sig) {
        if (isPossible(start, sig)) ct++;
        visited[start.node] = true;
        for (Edge adj: adjList.get(start.node)) {
            if (!visited[adj.node])
                traverse(adjList, new Edge(adj.node, start.cost + adj.cost), visited, sig);
        }
    }

    private int specialDfs(List<List<Edge>> adjList, int startNode, int signal) {
        if (adjList.get(startNode).size() < 2) return 0;
        int[] sum = new int[adjList.get(startNode).size()];
        int i = 0, total = 0;
        for (Edge adj: adjList.get(startNode)) {
            ct = 0;
            boolean[] visited = new boolean[adjList.size()];
            visited[startNode] = true;
            traverse(adjList, adj, visited, signal);
            sum[i] = ct;
            total += sum[i++];
        }
        int count = 0;
        for (int val: sum) count += (total - val) * val;
        return count / 2;
    }

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        List<List<Edge>> adjList = new ArrayList<>();
        int n = edges.length + 1;
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(new Edge(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }
        int[] count = new int[n];
        for (int i = 0; i < n; i++)
            count[i] = specialDfs(adjList, i, signalSpeed);
        return count;
    }

    public static void main(String[] args) {
        new CountPairOfConnectableServers().countPairsOfConnectableServers(
                new int[][]{
                        {1,0,2},{2,1,4},{3,2,4},{4,0,3},{5,1,4},{6,2,2},{7,6,4},{8,1,2},{9,8,3}}
        , 1);
    }
}
