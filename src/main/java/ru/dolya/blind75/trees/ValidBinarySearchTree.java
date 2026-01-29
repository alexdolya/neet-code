package ru.dolya.blind75.trees;

import static ru.dolya.blind75.trees.util.TreeNodeUtils.createTree;

public class ValidBinarySearchTree {

    public static void main(String[] args) {
        TreeNode valid = createTree(new Integer[]{2, 1, 3});
        TreeNode notValid = createTree(new Integer[]{1, 2, 3});
        TreeNode notValid1 = createTree(new Integer[]{5, 4, 6, null, null, 3, 7});

        System.out.println(isValidBST(valid));
        System.out.println(isValidBST(notValid));
        System.out.println(isValidBST(notValid1));
    }

    public static boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean valid(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        if (!(left < node.val && node.val < right)) {
            return false;
        }
        return valid(node.left, left, node.val) &&
                valid(node.right, node.val, right);
    }
}