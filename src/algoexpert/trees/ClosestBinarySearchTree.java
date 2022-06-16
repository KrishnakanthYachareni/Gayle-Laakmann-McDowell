package algoexpert.trees;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 */
public class ClosestBinarySearchTree {

    // Algo Expert TC = O(H), H = Height of the tree
    public static int findClosestValueInBst(BST tree, int target) {
        int closestValue = tree.value;
        BST currentNode = tree;

        while (currentNode != null) {
            if (Math.abs(currentNode.value - target) < Math.abs(closestValue - target))
                closestValue = currentNode.value;

            if (target < currentNode.value)
                currentNode = currentNode.left;
            else if (target > tree.value)
                currentNode = currentNode.right;
            else
                break;
        }
        return closestValue;
    }

    // LC
    public int closestValue(TreeNode root, double target) {

        int closest = root.val, currentValue;
        while (root != null) {
            currentValue = root.val;

            closest = Math.abs(currentValue - target) < Math.abs(closest - target) ? currentValue : closest;

            root = target < root.val ? root.left : root.right;
        }

        return closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
