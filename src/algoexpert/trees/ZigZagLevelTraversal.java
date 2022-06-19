package algoexpert.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigZagLevelTraversal {

    private final List<List<Integer>> result = new ArrayList<>();

    // DFS approach: This is same as level order traversal but for ODD level (right to left)
    // and EVEN level left to right adding the elements into list
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return result;

        levelOrderHelper(root, 0);
        return result;
    }

    private void levelOrderHelper(TreeNode root, int level) {
        if (result.size() == level)
            result.add(new ArrayList<>());

        if ((level) % 2 == 0) {
            result.get(level).add(root.val); // Left to right
        } else {
            result.get(level).add(0, root.val); // Right to left (Adding at 0 index)
        }
        if (root.left != null)
            levelOrderHelper(root.left, level + 1);

        if (root.right != null)
            levelOrderHelper(root.right, level + 1);
    }
}
