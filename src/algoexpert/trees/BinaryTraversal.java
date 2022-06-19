package algoexpert.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTraversal {

    // Iterative solutions are important
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return result;

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            result.add(currentNode.val);

            if (currentNode.right != null)
                stack.push(currentNode.right);

            if (currentNode.left != null)
                stack.push(currentNode.left);
        }
        return result;
    }


    // https://www.youtube.com/watch?v=qT65HltK2uE
    // Using two stacks
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderList = new ArrayList<>();

        if (root == null)
            return postOrderList;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            TreeNode currentNode = s1.pop();
            s2.push(currentNode);

            if (currentNode.left != null)
                s1.push(currentNode.left);

            if (currentNode.right != null)
                s1.push(currentNode.right);
        }

        while (!s2.isEmpty()) {
            postOrderList.add(s2.pop().val);
        }
        return postOrderList;
    }

   /*
   Recursive solutions
   ----------------------
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree != null) {
            inOrderTraverse(tree.left, array);
            array.add(tree.value);
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree != null) {
            array.add(tree.value);
            preOrderTraverse(tree.left, array);
            preOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree != null) {
            postOrderTraverse(tree.left, array);
            postOrderTraverse(tree.right, array);
            array.add(tree.value);
        }
        return array;
    }*/
}
