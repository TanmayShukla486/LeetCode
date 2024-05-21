package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTree {
    public int bfs(int node, List<List<Integer>> adj, int n) {
        int steps = 0;
        Queue<Integer> cache = new LinkedList<>();
        boolean[] visited = new boolean[n];
        cache.add(node);
        visited[node] = true;
        while (!cache.isEmpty()) {
            int size = cache.size();
            for (int i = 0; i < size; i++) {
                assert !cache.isEmpty();
                int current = cache.poll();
                for (int adjNode: adj.get(current)) {
                    if (!visited[adjNode]) {
                        cache.add(adjNode);
                        visited[adjNode] = true;
                    }
                }
            }
            steps++;
        }
        return steps;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int min = Integer.MAX_VALUE;
        int[] bfsSteps = new int[n];
        for (int i = 0; i < n; i++) {
            bfsSteps[i] = bfs(i, adj, n);
            min = Math.min(bfsSteps[i], min);
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (bfsSteps[i] == min) answer.add(i);
        }
        return answer;
    }
}
