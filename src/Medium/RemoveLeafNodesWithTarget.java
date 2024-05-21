package Medium;

public class RemoveLeafNodesWithTarget {
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        if (isLeaf(root) && root.val == target) return null;
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        if (left == null && right == null && root.val == target) return null;
        if (left == null) root.left = null;
        if (right == null) root.right = null;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,
                new TreeNode(5,
                        new TreeNode(7, new TreeNode(2), null), null),
                new TreeNode(2));
        new RemoveLeafNodesWithTarget().removeLeafNodes(root, 2);
    }
}
