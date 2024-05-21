package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    private void helper(int[] candidates, int stInd, int target, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        } else if (target < 0) return;
        else if (stInd >= candidates.length) return;
        for (int i = stInd; i < candidates.length; i++) {
            if (i != stInd && candidates[i] == candidates[i - 1]) continue;
            curr.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], curr, ans);
            curr.remove(curr.size() - 1);
            helper(candidates, i + 1, target, curr, ans);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        new CombinationSumII().combinationSum2(new int[] {10,1,2,7,6,1,5}, 8);
    }
}
