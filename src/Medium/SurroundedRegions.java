package Medium;

public class SurroundedRegions {
    private boolean isInBounds(int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        int rows = board.length, cols = board[0].length;
        visited[i][j] = true;
        int[] dirR = {-1,0,1,0}, dirC = {0,1,0,-1};
        for (int k = 0; k < 4; k++) {
            int r = i + dirR[k], c = j + dirC[k];
            if (isInBounds(r, c, rows, cols) && !visited[r][c] && board[r][c] == 'O') {
                dfs(board, r, c, visited);
            }
        }
    }
    private void dfs2(char[][] board, int i, int j, boolean[][] visited) {
        int rows = board.length, cols = board[0].length;
        visited[i][j] = true;
        board[i][j] = 'X';
        int[] dirR = {-1,0,1,0}, dirC = {0,1,0,-1};
        for (int k = 0; k < 4; k++) {
            int r = i + dirR[k], c = j + dirC[k];
            if (isInBounds(r, c, rows, cols) && !visited[r][c] && board[r][c] == 'O') {
                dfs(board, r, c, visited);
            }
        }
    }

    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        // all edge row
        for (int i = 0; i < cols; i++) {
            if (!visited[0][i] && board[0][i] == 'O') dfs(board, 0, i, visited);
        }
        for (int i = 0; i < cols; i++) {
            if (!visited[rows - 1][i] && board[rows - 1][i] == 'O') dfs(board, rows - 1, i, visited);
        }
        // all edge cols
        for (int i = 0; i < rows; i++) {
            if (!visited[i][0] && board[i][0] == 'O') dfs(board, i, 0, visited);
        }
        for (int i = 0; i < rows; i++) {
            if (!visited[i][cols - 1] && board[i][cols - 1] == 'O') dfs(board, i, cols - 1, visited);
        }
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (!visited[i][j] && board[i][j] == 'O') dfs2(board, i, j, visited);
            }
        }
    }

    public static void main(String[] args) {
        new SurroundedRegions().solve(new char[][] {
                {'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'}, {'X','O','X','X'}
        });
    }
}
