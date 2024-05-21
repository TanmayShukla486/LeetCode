package Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    char stParen = '(', ltParen = ')';

    private void helper(int n, List<String> list, StringBuilder sb, int stCount, int ltCount) {
        if (sb.length() == 2 * n) {
            list.add(sb.toString());
            return;
        }
        if (stCount < n) {
            sb.append(stParen);
            stCount++;
            helper(n, list, sb, stCount, ltCount);
            stCount--;
            sb.setLength(sb.length() - 1);
        }
        if (ltCount < n && ltCount < stCount) {
            sb.append(ltParen);
            ltCount++;
            helper(n, list, sb, stCount, ltCount);
            sb.setLength(sb.length() - 1);
            ltCount--;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, ans, new StringBuilder(), 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
}
