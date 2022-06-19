package algoexpert.trees;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricBinaryTree {


    // TC = O (N), SC = O(N)
    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;

        return node1.val == node2.val &&
                isSymmetric(node1.left, node2.right) &&
                isSymmetric(node1.right, node2.left);
    }

    // TC = O (N), SC = O(N)
    /*public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        List<Integer> leftPath = new ArrayList<>();
        leftPath.add(root.val);
        leftPathHelper(root.left, leftPath);

        List<Integer> rightPath = new ArrayList<>();
        rightPath.add(root.val);
        rightPathHelper(root.right, rightPath);

        for (int i = 0; i < leftPath.size(); i++) {
            if (!leftPath.get(i).equals(rightPath.get(i)))
                return false;
        }
        return true;
    }

    private void leftPathHelper(TreeNode root, List<Integer> leftPath) {
        if (root == null) {
            leftPath.add(null);
            return;
        } else {
            leftPath.add(root.val);
        }
        leftPathHelper(root.left, leftPath);
        leftPathHelper(root.right, leftPath);
    }

    private void rightPathHelper(TreeNode root, List<Integer> rightPath) {
        if (root == null) {
            rightPath.add(null);
            return;
        } else {
            rightPath.add(root.val);
        }
        rightPathHelper(root.right, rightPath);
        rightPathHelper(root.left, rightPath);
    }*/
}
