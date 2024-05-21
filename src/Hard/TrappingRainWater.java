package Hard;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftWall = new int[n];
        int[] rightWall = new int[n];
        leftWall[0] = height[0];
        rightWall[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            int right = n - 1 - i;
            leftWall[i] = Math.max(height[i], leftWall[i - 1]);
            rightWall[right] = Math.max(height[right], rightWall[right + 1]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftWall[i], rightWall[i]);
            water += Math.max(0, minHeight - height[i]);
        }
        return water;
    }

    public static void main(String[] args) {
        new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
