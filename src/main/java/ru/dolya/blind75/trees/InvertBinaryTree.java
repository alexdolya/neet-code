package ru.dolya.blind75.trees;

import java.util.LinkedList;
import java.util.Queue;

import static ru.dolya.blind75.trees.util.TreeNodeUtils.createTree;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = createTree(new int[]{1, 2, 3, 4, 5, 6, 7});

        TreeNode inverted = invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode left = current.left;
            TreeNode right = current.right;

            current.left = right;
            current.right = left;
            if (left != null) {
                queue.offer(left);
            }

            if (right != null) {
                queue.offer(right);
            }
        }

        return root;
    }
}
