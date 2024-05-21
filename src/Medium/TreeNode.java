package Medium;

public class TreeNode {
    public TreeNode(int val) {
        this.val = val;
    }

    public int val;
    public TreeNode left, right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
