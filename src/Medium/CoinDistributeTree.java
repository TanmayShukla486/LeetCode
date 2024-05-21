package Medium;

public class CoinDistributeTree {
    public int distributeCoins(TreeNode root) {
        if (root == null) return 0;
        int left = distributeCoins(root.left);
        int right = distributeCoins(root.right);
        root.val += left + right;
        return (root.val <= 0) ? 0: root.val - 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, new TreeNode(3), new TreeNode(0));
        new CoinDistributeTree().distributeCoins(root);
    }
}
