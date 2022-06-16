package algoexpert.trees;

public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Case 1: If both the children are null
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Case 2: If one of the children are null
            else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                // Case 3: If both are non-null children then replace the maximum node from the left subtree or minimum node from the right subtree.
                root.val = getMinimumValue(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int getMinimumValue(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }
}
