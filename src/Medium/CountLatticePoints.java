package Medium;

public class CountLatticePoints {
    private boolean inBounds(int x, int y, int x1, int y1, int r) {
        return (x - x1) * (x - x1) + (y - y1) * (y - y1) <= r*r;
    }

    private void helper(int[] center, boolean[][] visited, int[] count) {
        int x = center[0], y = center[1], radius = center[2];
        // A circle is contained within a square and what we need to do is to go from the bottom
        // left corner of the square and consider all points inside the square
        // if these points are in the circle and have not yet been visited we increase count
        // otherwise we skip and distance formula = (x - x1)^2 + (y - y1)^2 <= r^2
        for (int x1 = x - radius; x1 <= x + radius; x1++) {
            for (int y1 = y - radius; y1 <= y + radius; y1++) {
                if (inBounds(x, y, x1, y1, radius) && !visited[x1][y1]){
                    visited[x1][y1] = true; count[0]++;
                }
            }
        }
    }

    public int countLatticePoints(int[][] circles) {
        int[] count = {0};
        boolean[][] visited = new boolean[101][101];
        for (int[] circle : circles) helper(circle, visited, count);
        return count[0];
    }

    public static void main(String[] args) {
        new CountLatticePoints().countLatticePoints(new int[][] {{8,9,6},{9,8,4},{4,1,1},{8,5,1},{7,1,1},{6,7,5},{7,1,1},{7,1,1},{5,5,3}});
    }
}
