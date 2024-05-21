package Medium;




public class KthSmallestTree {


    private void helper(TreeNode root, int[] count, TreeNode answer) {
        // Base case: if the current node is null, return
        if (root == null) return;

        // Traverse the left subtree
        helper(root.left, count, answer);

        // If kth smallest element is found
        if (count[0] == 1) {
            // Update the answer with the value of the current node
            answer.val = root.val;
            // Decrement count to indicate that kth smallest element is found
            count[0] = 0;
            return;
        }

        // Decrement count for each visited node
        count[0]--;

        // Traverse the right subtree
        helper(root.right, count, answer);
    }

    public int kthSmallest(TreeNode root, int k) {
        // Initialize count array to keep track of remaining nodes to visit
        int[] count = {k};

        // Initialize a TreeNode to store the answer
        TreeNode answer = new TreeNode(-1); // Dummy TreeNode to store the answer

        // Call helper function to find the kth smallest element
        helper(root, count, answer);

        // Return the value of the kth smallest element
        return answer.val;
    }

}
