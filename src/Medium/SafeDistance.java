package Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SafeDistance {

    private int rows, cols, maxMan = 0;

    private boolean inBounds(int i, int j) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }

    private void bfs(int[][] grid, int[][] dist, int i, int j) {
        Queue<Integer> rowInd = new LinkedList<>();
        Queue<Integer> colInd = new LinkedList<>();
        rowInd.add(i); colInd.add(j);
        dist[i][j] = 0;
        boolean[][] visited = new boolean[rows][cols];
        while(!rowInd.isEmpty()) {
            int r = rowInd.poll();
            int c = colInd.poll();
            int man = Math.abs(i - r) + Math.abs(j - c);
            if (dist[r][c] < man) continue;
            else dist[r][c] = man;
            maxMan = Math.max(maxMan, man);
            // up
            if(inBounds(r - 1, c) && !visited[r - 1][c]) {
                visited[r - 1][c] = true;
                rowInd.add(r - 1);
                colInd.add(c);
            }
            // right
            if(inBounds(r, c + 1) && !visited[r][c + 1]) {
                rowInd.add(r);
                colInd.add(c + 1);
                visited[r][c + 1] = true;
            }
            // down
            if(inBounds(r + 1, c) && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                rowInd.add(r + 1);
                colInd.add(c);
            }
            // left
            if(inBounds(r, c - 1) && !visited[r][c - 1]) {
                visited[r][c - 1] = true;
                rowInd.add(r);
                colInd.add(c - 1);
            }
        }
    }

    private boolean isSafe(int[][] dist, int sf, int i, int j, boolean[][] visited) {
        if (i == rows - 1 && j == rows - 1) return true;
        visited[i][j] = true;
        if (dist[i][j] < sf) return false;
        int[] dirR = {-1,0,1,0};
        int[] dirC = {0,1,0,-1};
        for (int d = 0; d < 4; d++) {
            int r = i + dirR[d], c = j + dirC[d];
            if (inBounds(r,c) && !visited[r][c]) {
                if (isSafe(dist, sf, r, c, visited)) return true;
            }
        }
        return false;
    }

    public int maximumSafenessFactor(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
//        int[][] arGrid = new int[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++)
//                arGrid[i][j] = grid.get(i).get(j);
//        }
        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    bfs(grid, dist, i, j);
            }
        }
        if (dist[0][0] == 0 || dist[rows - 1][cols - 1] == 0) return 0;
        int low = 0, high = maxMan; int mid = 0;
        int maxSf = 0;
        while (low <= high) {
            boolean[][] visited = new boolean[rows][cols];
            mid = (low + high) / 2;
            if (isSafe(dist, mid, 0, 0, visited)) {
                maxSf = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        for (int i = 0; i < rows; i++) System.out.println(Arrays.toString(dist[i]));
        return maxSf;
    }

    public static void main(String[] args) {
        SafeDistance obj = new SafeDistance();
        obj.rows = 3; obj.cols = 3;
        int[][] dist = new int[obj.rows][obj.cols];
        for (int i = 0; i < obj.rows; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        obj.maximumSafenessFactor(
                new int[][] {
                        {0,0,1},{0,0,0},{0,0,0}
                }
        );
    }
}
