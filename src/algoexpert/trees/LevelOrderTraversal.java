package algoexpert.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrderTraversal {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return result;

        levelOrderHelper(root, 0);
        return result;
    }

    private void levelOrderHelper(TreeNode root, int level) {
        if (result.size() == level)
            result.add(new ArrayList<>());

        result.get(level).add(root.val);

        if (root.left != null)
            levelOrderHelper(root.left, level + 1);

        if (root.right != null)
            levelOrderHelper(root.right, level + 1);
    }

    // TC = O(N), SC = O(N)
    /*public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultNodes = new ArrayList<>();

        if (root == null)
            return resultNodes;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.add(null);
        resultNodes.add(new ArrayList<>());

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode != null) {
                int value = currentNode.val;
                resultNodes.get(resultNodes.size() - 1).add(value);

                if (currentNode.left != null)
                    queue.add(currentNode.left);

                if (currentNode.right != null)
                    queue.add(currentNode.right);

            } else {
                if (queue.size() > 0) {
                    queue.add(null);
                    resultNodes.add(new ArrayList<>());
                }
            }
        }
        return resultNodes;
    }*/
}
