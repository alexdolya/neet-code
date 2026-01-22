package ru.dolya.blind75.trees.util;

import ru.dolya.blind75.trees.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtils {

    public static TreeNode createTree(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(arr.getFirst());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.size()) {
            TreeNode current = queue.poll();

            // Создаем левого потомка
            Integer val = arr.get(i);
            if (val != null) {
                current.left = new TreeNode(val);
                queue.offer(current.left);

            }
            i++;

            // Создаем правого потомка
            if (i < arr.size() ) {
                Integer val1 = arr.get(i);
                if (val != null) {
                    current.right = new TreeNode(val1);
                    queue.offer(current.right);
                }
            }
            i++;
        }

        return root;
    }
}
