package Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CellReachable {
    private boolean isInBounds(int i, int j, int rows, int cols) {
        return i <= rows && j <= cols;
    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (fx == sx && fy == sy && t == 1) return false;
        Queue<Integer> rowInd = new LinkedList<>();
        Queue<Integer> colInd = new LinkedList<>();
        int maxY = Math.max(fy, sy), maxX = Math.max(fx, sx);
        int minY = Math.min(fy, sy), minX = Math.min(fx, sx);
        int rows = maxY - minY + 1, cols = maxX - minX + 1;
        int[][] visited = new int[rows + 1][cols + 1];
        int steps = 0;
        for (int i = 0; i <= rows; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);
        rowInd.add(sy); colInd.add(sx);
        int[] dirR = {0,1,1,1,0,-1,-1,-1};
        int[] dirC = {1,1,0,-1,-1,-1,0,1};
        visited[0][0] = 0;
        while (!rowInd.isEmpty()) {
            int size = rowInd.size();
            for (int i = 0; i < size; i++) {
                int r = rowInd.poll(), c = colInd.poll();
                if (r == fy && c == fx && steps <= t) return true;
                else if (steps > t) return false;
                for (int k = 0; k < 8; k++) {
                    int p = r + dirR[k] - minY, q = c + dirC[k] - minX;
                    if (isInBounds(p, q, rows, cols) && visited[p][q] > steps + 1) {
                        visited[p][q] = steps + 1;
                        rowInd.add(p); colInd.add(q);
                    }
                }
            }
            steps++;
        }
        return false;
    }

    public static void main(String[] args) {
        new CellReachable().isReachableAtTime(2,4,7,7,6);
    }
}
