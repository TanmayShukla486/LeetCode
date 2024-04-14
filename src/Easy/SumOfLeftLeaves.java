package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

    private static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> cache = new LinkedList<>();
        cache.add(root);
        int count = 0;
        while (!cache.isEmpty()) {
            TreeNode current = cache.poll();
            if (current.left != null) {
                if (isLeaf(current.left)) count += current.left.val;
                cache.add(current.left);
            }
            if (current.right != null) cache.add(current.right);
        }
        return count;
    }

    private void helper(TreeNode root, int[] answer) {
        if (root == null) return;
        if (root.left != null && isLeaf(root.left)) answer[0] += root.left.val;
        helper(root.left, answer);
        helper(root.right, answer);
    }

    private int helper2(TreeNode root) {
        if (root == null) return 0;
        int answer = 0;
        if (root.left != null && isLeaf(root.left)) answer += root.left.val;
        return answer + helper2(root.left) + helper2(root.right);
    }

    public int SumOfLeaves2(TreeNode root) {
        if (root == null) return 0;
        int[] answer = {0};
        helper(root, answer);
        return answer[0];
    }

}
