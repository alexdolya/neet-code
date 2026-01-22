package ru.dolya.blind75.trees;

import java.util.*;

import static ru.dolya.blind75.trees.util.TreeNodeUtils.createTree;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = createTree(Arrays.asList(1, 2, 3, null, null, 4));
        System.out.println(maxDepth(root));
        System.out.println(maxDepthRecursion(root));
    }

    public static int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
    }

    public static int maxDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepthRecursion(root.left), maxDepthRecursion(root.right));
    }

}
