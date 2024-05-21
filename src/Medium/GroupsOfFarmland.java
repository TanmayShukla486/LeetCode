package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GroupsOfFarmland {
    static int rows, cols;

    // Method to check if given indices (i, j) are within the bounds of the grid
    private boolean isInBounds(int i, int j) {
        return (i >= 0) && (j >= 0) && i < rows && j < cols;
    }

    // Depth-first search (DFS) method to traverse the farmland and update the boundaries
    private void dfs(int[][] land, int row, int col, List<int[]> answer) {
        // Base case: If the indices are out of bounds or the cell is not part of farmland (value != 1), return
        if (!isInBounds(row, col) || land[row][col] != 1) return;

        // Get the index of the last added farmland in the answer list
        int index = answer.size() - 1;

        // Update the boundaries of the current farmland
        answer.get(index)[2] = Math.max(answer.get(index)[2], row); // Update bottom right row
        answer.get(index)[3] = Math.max(answer.get(index)[3], col); // Update bottom right col

        // Mark the current cell as visited by changing its value to 0
        land[row][col] = 0;

        // Recursively visit adjacent cells (right and down) to explore the farmland
        dfs(land, row, col + 1, answer); // Right
        dfs(land, row + 1, col, answer); // Down
    }

    // Method to find farmland in the given 2D array of land
    public int[][] findFarmland(int[][] land) {
        // Initialize a list to store the farmland coordinates (top left and bottom right corners)
        List<int[]> answer = new ArrayList<>();

        // Set the number of rows and columns of the land grid
        rows = land.length;
        cols = land[0].length;

        // Iterate through each cell in the land grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the current cell represents farmland (value == 1)
                if (land[i][j] == 1) {
                    // Add the top left and bottom right coordinates of the farmland to the answer list
                    answer.add(new int[]{i, j, i, j});

                    // Use depth-first search to update the boundaries of the current farmland
//                    dfs(land, i, j, answer);
                    findCoordinates(land, i, j, answer);
                }
            }
        }

        // Convert the list of farmland coordinates to a 2D array and return
        return answer.toArray(new int[0][]);
    }

    private void findCoordinates(int[][] land, int i, int j, List<int[]> answer) {
        // Initialize variables to store the bottom right coordinates of the farmland
        int row = 0, col = 0;

        // Traverse downwards to find the bottom row of the farmland
        for (int k = i; k < rows; k++) {
            if (land[k][j] == 1)
                row = k; // Update row if land is part of farmland
            else
                break; // Break if land is not part of farmland
        }

        // Traverse rightwards to find the rightmost column of the farmland
        for (int k = j; k < cols; k++) {
            if (land[i][k] == 1)
                col = k; // Update col if land is part of farmland
            else
                break; // Break if land is not part of farmland
        }

        // Mark the cells of the farmland as visited (set them to 0)
        for (; i <= row; i++) {
            for (int k = j; k <= col; k++) {
                land[i][k] = 0;
            }
        }

        // Update the bottom right coordinates of the farmland in the answer list
        answer.get(answer.size() - 1)[2] = row;
        answer.get(answer.size() - 1)[3] = col;
    }

}
