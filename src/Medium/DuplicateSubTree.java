package Medium;

import java.util.*;

public class DuplicateSubTree {

    private String helper(TreeNode root, List<TreeNode> ans, HashMap<String, Integer> hash) {
        if (root == null) return "#";
        String left = helper(root.left, ans, hash) + ",";
        String right = helper(root.right, ans, hash) + ",";
        String current = left + right;
        if (hash.getOrDefault(current, 0) == 1)
            ans.add(root);
        hash.put(current, hash.getOrDefault(current, 0) + 1);
        return current;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        helper(root, ans, hash);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-9,
                new TreeNode(-3, null,
                        new TreeNode(4, new TreeNode(-6), null)),
                new TreeNode(2,
                        new TreeNode(4, new TreeNode(5), null),
                        new TreeNode(0)));
        new DuplicateSubTree().findDuplicateSubtrees(root);
    }
}
