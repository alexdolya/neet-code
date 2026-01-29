package ru.dolya.blind75.trees;

import java.util.*;

import static ru.dolya.blind75.trees.util.TreeNodeUtils.createTree;

public class KthSmallestIntegerInBST {

    public static void main(String[] args) {
        TreeNode tree = createTree(new Integer[]{2, 1, 3});
        System.out.println(kthSmallest(tree, 1));
    }

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> vals = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            vals.add(current.val);

            if (current.right != null) {
                queue.offer(current.right);
            }

            if (current.left != null) {
                queue.offer(current.left);
            }
        }
        if (k > vals.size()) {
            return 0;
        }
        Collections.sort(vals);

        return vals.get(k - 1);
    }
}
