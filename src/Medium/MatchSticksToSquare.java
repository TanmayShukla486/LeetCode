package Medium;

public class MatchSticksToSquare {
    private boolean helper(int[] matches, int currSide, int sideLength, int ind) {
        if (currSide > 4) return ind == matches.length;
        int sum = 0;
        for (int i = ind; i < matches.length; i++) {
            sum += matches[i];
            if (sideLength != 0 && sum > sideLength) return false;
            if (helper(matches, currSide + 1, sum, i + 1)) return true;
        }
        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        return helper(matchsticks, 1, 0, 0);
    }

    public static void main(String[] args) {
        new MatchSticksToSquare().makesquare(new int[] {3,3,3,3,4});
    }
}
