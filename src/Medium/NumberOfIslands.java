package Medium;

public class NumberOfIslands {
    static int n, m;

    // Method to check if given indices (r, c) are within the bounds of the grid
    private boolean isInBounds(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < n) && (c < m);
    }

    // Method to mark an island as visited and recursively cover adjacent cells
    private void coverIsland(char[][] grid, int i, int j) {
        // Base case: If the indices are out of bounds or the cell is not part of an island ('1'), return
        if (!isInBounds(i, j) || grid[i][j] != '1') return;

        // Mark the current cell as visited by changing '1' to '*'
        grid[i][j] = '*';

        // Recursively cover adjacent cells in all four directions
        coverIsland(grid, i - 1, j); // Up
        coverIsland(grid, i, j + 1); // Right
        coverIsland(grid, i + 1, j); // Down
        coverIsland(grid, i, j - 1); // Left
    }

    // Method to count the number of islands in the grid
    public int numIslands(char[][] grid) {
        // Get the dimensions of the grid
        n = grid.length;
        m = grid[0].length;

        // Initialize island count
        int count = 0;

        // Iterate through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the current cell is part of an unvisited island ('1')
                if (grid[i][j] == '1') {
                    // Increment island count
                    count++;
                    // Mark the island and all its connected cells as visited
                    coverIsland(grid, i, j);
                }
            }
        }

        // Return the total count of islands
        return count;
    }

}
