package ru.dolya.blind75.trees;

import java.util.LinkedList;
import java.util.Queue;

import static ru.dolya.blind75.trees.util.TreeNodeUtils.createTree;

public class LowestCommonAncestorInBinarySearchTree {

    public static void main(String[] args) {
        TreeNode tree = createTree(new Integer[]{5, 3, 8, 1, 4, 7, 9, null, 2});
        TreeNode treeNode = lowestCommonAncestor(tree, tree.left, tree.right);
        TreeNode treeNodeB = lowestCommonAncestorBinary(tree, tree.left, tree.right);

        TreeNode tree1 = createTree(new Integer[]{5, 3, 8, 1, 4, 7, 9, null, 2});
        TreeNode treeNode1 = lowestCommonAncestor(tree1, tree1.left, tree1.left.right);
        TreeNode treeNode1B = lowestCommonAncestorBinary(tree1, tree1.left, tree1.left.right);
    }

    public static TreeNode lowestCommonAncestorBinary(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else  if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        TreeNode result = null;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (containsNode(current, p) && containsNode(current, q)) {
                result = current;
            }

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return result;
    }

    public static boolean containsNode(TreeNode node, TreeNode forFind) {
        if (node == null) {
            return false;
        }

        if (node.val == forFind.val) {
            return true;
        }

        if ((node.left != null && node.left.val == forFind.val)
                || (node.right != null && node.right.val == forFind.val))
            return true;

        return containsNode(node.left, forFind) || containsNode(node.right, forFind);
    }

}
