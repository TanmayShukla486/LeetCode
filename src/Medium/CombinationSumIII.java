package Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    private void helper(int maxCount, int target, int currCount, List<Integer> curr, boolean[] visited, List<List<Integer>> ans) {
        if (currCount == maxCount) {
            if (target == 0) ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (!visited[i]) {
                curr.add(i);
                helper(maxCount, target - i, currCount + 1, curr, visited, ans);
                visited[i] = true;
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(k, n, 0, new ArrayList<>(), new boolean[10], ans);
        return ans;
    }

    public static void main(String[] args) {
        new CombinationSumIII().combinationSum3(3,9);
    }
}
