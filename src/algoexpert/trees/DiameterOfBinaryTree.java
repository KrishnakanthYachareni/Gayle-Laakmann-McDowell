package algoexpert.trees;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {

    private int diameter = Integer.MIN_VALUE;

    // TC = O (N), SC = O(H) Height of BT
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return diameter;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
