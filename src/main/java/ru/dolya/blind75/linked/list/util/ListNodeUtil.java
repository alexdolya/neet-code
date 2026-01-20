package ru.dolya.blind75.linked.list.util;

import ru.dolya.blind75.linked.list.ListNode;

public class ListNodeUtil {

    public static ListNode createLinkedList(int[] values) {
        ListNode prev = null;
        for (int i = values.length - 1; i >= 0; i--) {
            prev = new ListNode(values[i], prev);
        }
        return prev;
    }

    public static void printLinkedList(ListNode current) {
        System.out.println(linkedListToString(current));
    }

    public static String linkedListToString(ListNode current) {
        if (current == null) {
            return "";
        }
        ListNode next = current.getNext();
        StringBuilder stringBuilder = new StringBuilder();
        while (next != null) {
            stringBuilder.append(current.getVal());
            stringBuilder.append(" ");
            current = next;
            next = current.getNext();
        }
        stringBuilder.append(current.getVal());
        stringBuilder.append(" ");
        return stringBuilder.toString().trim();
    }
}
