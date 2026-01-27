package ru.dolya.blind75.trees;

import java.util.*;

import static ru.dolya.blind75.trees.util.TreeNodeUtils.createTree;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode tree = createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(levelOrderSecond(tree));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> currentResult = new ArrayList<>();
        int currentLevelSize = 1;
        int nextLevelSize = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            currentResult.add(current.val);

            if (current.left != null) {
                queue.offer(current.left);
                nextLevelSize++;
            }

            if (current.right != null) {
                queue.offer(current.right);
                nextLevelSize++;
            }

            currentLevelSize--;

            if (currentLevelSize == 0) {
                result.add(currentResult);
                currentResult = new ArrayList<>();
                currentLevelSize = nextLevelSize;
                nextLevelSize = 0;
            }
        }

        return result;
    }

    public static List<List<Integer>> levelOrderSecond(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currentResult = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    currentResult.add(current.val);
                    if (current.left != null) {
                        queue.offer(current.left);
                    }

                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }

            }
            if (!currentResult.isEmpty()) {
                result.add(currentResult);
            }
        }
        return result;
    }

}
