package ru.dolya.blind75.trees.util;

import ru.dolya.blind75.trees.TreeNode;

import java.util.*;

public class TreeNodeUtils {

    public static TreeNode createTree(Integer[] arr) {
        return createTree(new ArrayList<>(Arrays.asList(arr)));
    }

    public static TreeNode createTree(List<Integer> list) {

        if (list == null || list.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(list.getFirst());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < list.size()) {
            TreeNode current = queue.poll();

            // Создаем левого потомка
            Integer val = list.get(i);
            if (val != null) {
                current.left = new TreeNode(val);
                queue.offer(current.left);

            }
            i++;

            // Создаем правого потомка
            if (i < list.size()) {
                Integer val1 = list.get(i);
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
