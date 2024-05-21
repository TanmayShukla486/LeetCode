package Medium;

import java.util.ArrayList;
import java.util.List;

public class LongestIdealSubsequence {
    private void helper(char[] ch, int index, List<Character> ans, int[] len, int k, int lastInd) {
        if (index == ch.length) {
            len[0] = Math.max(ans.size(), len[0]);
            return;
        }
        if (index == 0 || Math.abs(ch[index] - ch[lastInd]) <= k) {
            ans.add(ch[index]);
            helper(ch, index + 1, ans, len, k, index);
            ans.remove(ans.size() - 1);
            helper(ch, index + 1, ans, len, k, lastInd);
        } else helper(ch, index + 1, ans, len, k, lastInd);
    }

    public int longestIdealString(String s, int k) {
        int[] len = {0};
        helper(s.toCharArray(), 0, new ArrayList<>(), len, k, 0);
        return len[0];
    }

    public static void main(String[] args) {
        new LongestIdealSubsequence().longestIdealString("pvjcci", 4);
    }
}
