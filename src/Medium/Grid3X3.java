package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Grid3X3 {

    private boolean inBounds(int i, int j) {
        return i >= 0 && i < 3 && j >= 0 && j < 3;
    }

    private void bfs(int[][] grid, int[][] cost, int x, int y) {
        Queue<Integer> row = new LinkedList<>(); Queue<Integer> col = new LinkedList<>();
        row.add(x); col.add(y);
        int[] dirR = {0,1,0,-1};
        int[] dirC = {1,0,-1,0};
        boolean[][] visited = new boolean[3][3];
        int steps = 0;
        while (!row.isEmpty()) {
            int size = row.size();
            for (int i = 0; i < size; i++) {
                int r = row.poll(), c = col.poll();
                for (int j = 0; j < 4; j++) {
                    int p = r + dirR[j], q = c + dirC[j];
                    if (inBounds(p, q) && !visited[p][q]) {
                        row.add(p);
                        col.add(q);
                        visited[p][q] = true;
                        if (grid[p][q] == 0) {
                            if (cost[p][q] == 0) cost[p][q] = steps + 1;
                            else cost[p][q] = Math.min(cost[p][q], steps + 1);
                        }
                    }
                }
            }
            steps++;
        }
    }

    public int minimumMoves(int[][] grid) {
        Queue<Integer> rowInd = new LinkedList<>(), colInd = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] > 1) {
                    rowInd.add(i); colInd.add(j);
                }
            }
        }
        int[][] cost = new int[3][3];
        while (!rowInd.isEmpty()) {
            int i = rowInd.poll(), j = colInd.poll();
            bfs(grid, cost, i, j);
        }
        int totalCost = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                totalCost += cost[i][j];
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        new Grid3X3().minimumMoves(new int[][] {
                {1,1,0},{1,1,1},{1,2,1}
        });
    }
}
