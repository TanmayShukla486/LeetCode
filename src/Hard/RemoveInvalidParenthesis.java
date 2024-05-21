package Hard;

import java.util.*;

public class RemoveInvalidParenthesis {
    int minCost = Integer.MAX_VALUE;
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(') stack.add(c);
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private void helper(
            char[] c,
            int ind,
            StringBuilder sb,
            Map<String, Integer> vals
    ) {
        if (ind >= c.length) {
            if (isValid(sb.toString())){
                vals.put(sb.toString(), c.length - sb.length());
                minCost = Math.min(minCost, c.length - sb.length());
            }
            return;
        }
        if (Character.isLetter(c[ind])) {
            sb.append(c[ind]);
            helper(c, ind + 1, sb, vals);
            sb.setLength(sb.length() - 1);
        }
        else {
            sb.append(c[ind]);
            helper(c, ind + 1, sb, vals);
            sb.setLength(sb.length() - 1);
            helper(c, ind + 1, sb, vals);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        Map<String, Integer> answer = new HashMap<>();
        helper(s.toCharArray(), 0, new StringBuilder(), answer);
        List<String> ans = new ArrayList<>();
        for (String key: answer.keySet()) {
            if (answer.get(key) == minCost) ans.add(key);
        }
        return ans;
    }

    public static void main(String[] args) {
        new RemoveInvalidParenthesis().removeInvalidParentheses(")(f");
    }
}
