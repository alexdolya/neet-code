package ru.dolya.blind75.trees;

import java.util.List;

import static ru.dolya.blind75.trees.util.TreeNodeUtils.createTree;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        System.out.println(isSubtree(createTree(List.of(1, 2, 3, 4, 5)), createTree(List.of(2, 4, 5))));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (sameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    public static boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot != null && root.val == subRoot.val) {
            return sameTree(root.left, subRoot.left) &&
                    sameTree(root.right, subRoot.right);
        }
        return false;
    }
}
