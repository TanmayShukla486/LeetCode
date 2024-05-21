package Hard;

import java.util.*;

public class DistancesTree {
    static class Pair {
        int node, dist;
        private Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        public static Pair create(int l1, int l2) {
            return new Pair(l1, l2);
        }
        public int getDist() {
            return dist;
        }
    }

    public int helper(List<List<Integer>> adjList, int node, int n) {
        int inf = (int) 1e9;
        int[] distances = new int[n];
        Arrays.fill(distances, inf);
        distances[node] = inf;
        PriorityQueue<Pair> cache = new PriorityQueue<>(Comparator.comparingInt(Pair::getDist));
        cache.add(Pair.create(node, 0));
        while (!cache.isEmpty()) {
            Pair current = cache.poll();
            for (int adjacent: adjList.get(current.node)) {
                int currentDistance = current.dist + 1;
                if (distances[adjacent] > currentDistance) {
                    distances[adjacent] = currentDistance;
                    cache.add(Pair.create(adjacent, currentDistance));
                }
            }
        }
        int sum = 0;
        for (int distance: distances) sum += distance;
        return sum;
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = helper(adjList, i, n);
        }
        return answer;
    }
}
