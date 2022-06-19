package algoexpert.trees;

public class LowestCommonAncestorOfBinaryTree {


    /*
     * Approach1: Simply find the paths for p, q and compare the paths until the paths are not equals
     * and that node becomes the lowest common ancestor.
     * But it takes extra space O (N)
     *
     * Approach2: https://www.youtube.com/watch?v=13m9ZCB8gjw
     * TC = O(N), SC = O(N)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        if (left == null && right == null)
            return null;

        return left != null ? left : right;
    }
}
