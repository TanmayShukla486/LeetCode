package Medium;

public class NumberOfRightAngles {
    public long numberOfRightTriangles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        /*Brute Force: TLE */
        // // int[][] hasRow = new boolean[rows][cols];
        // // int[][] hasCol = new boolean[rows][cols];
        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         if (grid[i][j] == 1) {
        //             // explore the row
        //             long rowCount = 0;
        //             for (int k = j + 1; k < cols; k++)
        //                 rowCount += (grid[i][k] == 1) ? 1L : 0L;
        //             for (int k = j - 1; k >= 0; k--)
        //                 rowCount += (grid[i][k] == 1) ? 1L : 0L;
        //             // exploring cols
        //             long colCount = 0;
        //             for (int k = i + 1; k < rows; k++)
        //                 colCount += (grid[k][j] == 1) ? 1L : 0L;
        //             for (int k = i - 1; k >= 0; k--)
        //                 colCount += (grid[k][j] == 1) ? 1L : 0L;
        //             count += rowCount * colCount;
        //         }
        //     }
        // }
        long[] rowCount = new long[rows];
        long[] colCount = new long[cols];
        for (int i = 0; i < rows; i++) {
            long count = 0L;
            for (int j = 0; j < cols; j++)
                count += (grid[i][j] == 1) ? 1L : 0L;
            rowCount[i] = count;
        }
        for (int j = 0; j < cols; j++) {
            long count = 0;
            for (int i = 0; i < rows; i++)
                count += (grid[i][j] == 1) ? 1L : 0L;
            colCount[j] = count;
        }
        long count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                count += (grid[i][j] == 0) ? (rowCount[i] - 1L) * (colCount[j] - 1L) : 0L;
        }
        return count;
    }

    public static void main(String[] args) {
        new NumberOfRightAngles().numberOfRightTriangles(
                new int[][] {
                        {0,1,0}, {0,1,1}, {0,1,0}
                }
        );
    }
}
