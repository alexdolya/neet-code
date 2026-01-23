package ru.dolya.blind75.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static ru.dolya.blind75.trees.util.TreeNodeUtils.createTree;

public class SameBinaryTree {

    public static void main(String[] args) {
        TreeNode root1 = createTree(Arrays.asList(1, 2, 3, null, null, 4));
        TreeNode root2 = createTree(Arrays.asList(1, 2, 3, null, null, 4));
        System.out.println(isSameTree(root1, root2));
        System.out.println(isSameTreeRecursive(root1, root2));

        TreeNode root3 = createTree(Arrays.asList(1, 5, 3, 10, 15, 4));
        TreeNode root4 = createTree(Arrays.asList(1, 2, 3, null, null, 4));
        System.out.println(isSameTree(root3, root4));
        System.out.println(isSameTreeRecursive(root3, root4));

        TreeNode root5 = createTree(Arrays.asList(4, 7));
        TreeNode root6 = new TreeNode(4);
        root6.left = null;
        root6.right = new TreeNode(7);
        System.out.println(isSameTree(root5, root6));
        System.out.println(isSameTreeRecursive(root5, root6));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null) {
            return false;
        }

        if (q == null) {
            return false;
        }

        Queue<TreeNode> pQueue = new LinkedList<>();
        pQueue.offer(p);

        Queue<TreeNode> qQueue = new LinkedList<>();
        qQueue.offer(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pCurrent = pQueue.poll();
            TreeNode qCurrent = qQueue.poll();

            if (pCurrent != null) {
                TreeNode pLeft = pCurrent.left;
                TreeNode pRight = pCurrent.right;
                pQueue.offer(pLeft);
                pQueue.offer(pRight);
            }

            if (qCurrent != null) {
                TreeNode qLeft = qCurrent.left;
                TreeNode qRight = qCurrent.right;
                qQueue.offer(qLeft);
                qQueue.offer(qRight);
            }

            if ((pCurrent == null && qCurrent != null)
                    || (pCurrent != null && qCurrent == null)) {
                return false;
            }

            if (pCurrent != null) {
                if (pCurrent.val != qCurrent.val) {
                    return false;
                }
            }

        }

        return qQueue.isEmpty() && pQueue.isEmpty();
    }

    public static boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
