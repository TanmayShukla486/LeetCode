package Easy;

public class IslandPerimeter {
    private boolean isInBounds(int i, int j, int r, int c) {
        return (i >= 0) && (j >= 0) && (i < r) && (j < c);
    }

    private int findPerimeter(int[][] grid, int i, int j) {
        int row = grid.length, col = grid[0].length;
        int value = 0;
        // Top
        if (isInBounds(i - 1, j, row, col) && grid[i - 1][j] == 0) {
            value++;
        } else if (!isInBounds(i - 1, j, row, col)) value++;
        // Bottom
        if (isInBounds(i + 1, j, row, col) && grid[i + 1][j] == 0) value++;
        else if (!isInBounds(i + 1, j, row, col)) value++;
        // Right
        if (isInBounds(i, j + 1, row, col) && grid[i][j + 1] == 0) value++;
        else if (!isInBounds(i, j + 1, row, col)) value++;
        // Left
        if (isInBounds(i, j - 1, row, col) && grid[i][j - 1] == 0) value++;
        else if (!isInBounds(i, j - 1, row, col)) value++;
        return value;
    }

    private void helper(int[][] grid, boolean[][] visited, int row, int col, int[] count) {
        visited[row][col] = true;
        count[0] += findPerimeter(grid, row, col);
        int[] rowDirection = {-1,0,1,0};
        int[] colDirection = {0,1,0,-1};
        for (int i = 0; i < 4; i++) {
            int toRow = row + rowDirection[i];
            int toCol = col + colDirection[i];
            if (isInBounds(toRow, toCol, grid.length, grid[0].length)
                    && !visited[toRow][toCol]
                    && grid[toRow][toCol] == 1) {
                helper(grid, visited, toRow, toCol, count);
            }
        }
    }

    public int islandPerimeter(int[][] grid) {
        int[] count = {0};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int row = 0, col = 0;
        boolean found = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    found = true;
                    row = i; col = j; break;
                }
            }
            if (found) break;
        }
        helper(grid, visited, row, col, count);
        return count[0];
    }

    public static void main(String[] args) {
        new IslandPerimeter().islandPerimeter(new int[][] {
//                {0,1,0,0},
//                {1,1,1,0},
//                {0,1,0,0},
//                {1,1,0,0}
                {0},{1}
        });
    }
}
