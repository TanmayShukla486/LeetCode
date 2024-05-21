package Medium;

import java.util.HashSet;
import java.util.Set;

public class UniquePaths {
    private boolean isInBounds(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    private void helper(int i, int j, int m, int n, String curr, Set<String> ans) {
        if (!isInBounds(i, j, m, n)) return;
        else if (i == m - 1 && j == n - 1) {
            ans.add(curr);
            return;
        }
        helper(i + 1, j, m, n, curr + "d", ans);
        helper(i, j + 1, m, n, curr + "r", ans);
    }

    public int uniquePaths(int m, int n) {
        Set<String> ans = new HashSet<>();
        helper(0,0,m,n,"", ans);
        return ans.size();
    }

    public static void main(String[] args) {
        new UniquePaths().uniquePaths(3,7);
    }
}
