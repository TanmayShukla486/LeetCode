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

    /**Function to check if the current node is a leaf node or not*/
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    /**Function to find sum of left leaf nodes via BFS traversal*/
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> cache = new LinkedList<>();
        cache.add(root);
        int count = 0;
        while (!cache.isEmpty()) {
            TreeNode current = cache.poll();
            // checking if left branch is not null
            if (current.left != null) {
                // if left branch is a leaf node adding its value
                if (isLeaf(current.left)) count += current.left.val;
            }
            // adding non leaf and non-null right branches to the cache
            if (current.right != null && !isLeaf(current.right)) cache.add(current.right);
        }
        return count;
    }

    /**Using Pass by reference to get the sum of left leaves via DFS*/
    private void helper(TreeNode root, int[] answer) {
        if (root == null) return;
        if (root.left != null && isLeaf(root.left)) answer[0] += root.left.val;
        helper(root.left, answer);
        helper(root.right, answer);
    }

    /**Using basic recursion to get sum of left leaves via DFS*/
    private int helper2(TreeNode root) {
        if (root == null) return 0;
        int answer = 0;
        if (root.left != null && isLeaf(root.left)) answer += root.left.val;
        return answer + helper2(root.left) + helper2(root.right);
    }

    /**finding sum of left leaves via pass by reference or recursion or bfs*/
    public int SumOfLeaves2(TreeNode root) {
        if (root == null) return 0;
        int[] answer = {0};
        helper(root, answer);
        return answer[0];
    }

}
