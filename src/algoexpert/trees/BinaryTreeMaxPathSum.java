package algoexpert.trees;

/*
 * There are 4 possible options to get the maximum path:
 * 1. Left sub path sum
 * 2. Right sub path sum
 * 3. Left path sum + right path sum + root value
 * 4. or root value itself (When root is value is negative)
 *
 * We have to consider the maximum of all these sums, that gives us the maximum path sum of the binary tree.
 *
 * https://www.youtube.com/watch?v=6cA_NDtpyz8
 */
public class BinaryTreeMaxPathSum {
    private int maximumPathSum = Integer.MIN_VALUE;

    // TC = O (N), SC = O(H) Height of BT
    public int maxPathSum(TreeNode root) {
        postOrder(root);

        return maximumPathSum;
    }

    private int postOrder(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = Math.max(postOrder(root.left), 0);
        int rightMax = Math.max(postOrder(root.right), 0);

        maximumPathSum = Math.max(maximumPathSum, leftMax + rightMax + root.val);

        return root.val + Math.max(leftMax, rightMax);
    }
}
