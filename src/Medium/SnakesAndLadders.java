package Medium;

import java.util.*;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean ltr = true;
        List<Integer> boardList = new ArrayList<>();
        boardList.add(1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int col = (ltr) ? j : (n - 1) - j;
                boardList.add(board[i][col]);
            }
            ltr = !ltr;
        }
        Queue<Integer> squares = new LinkedList<>();
        squares.add(1);
        int steps = 0;
        int[] dist = new int[boardList.size()];
        Arrays.fill(dist, -1);
        dist[0] = 0; dist[1] = 0;
        squares.add(1);
        while (!squares.isEmpty()){
            int curr = squares.poll();
            for (int next = curr + 1; next <= Math.min(curr + 6, n*n); next++) {
                int val = boardList.get(next);
                int dest = val == -1 ? next : val;
                if (dist[dest] == -1) {
                    dist[dest] = dist[curr] + 1;
                    squares.add(dest);
                }
            }
        }
        return dist[n*n];
    }
}
