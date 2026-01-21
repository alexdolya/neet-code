package ru.dolya.blind75.trees.util;

import ru.dolya.blind75.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeUtils {

    public static TreeNode createTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Создаем левого потомка
            current.left = new TreeNode(arr[i]);
            queue.offer(current.left);
            i++;

            // Создаем правого потомка
            if (i < arr.length ) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}
