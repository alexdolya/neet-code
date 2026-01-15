package ru.dolya.blind75.linked.list;

import static ru.dolya.blind75.linked.list.util.ListNodeUtil.createLinkedList;
import static ru.dolya.blind75.linked.list.util.ListNodeUtil.printLinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode firstNode = createLinkedList(new int[]{0, 1, 2, 3});
        ListNode reversedList = reverseList(firstNode);
        printLinkedList(reversedList);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode prev = null;
        while (next != null) {
            head.next = prev;
            prev = head;
            head = next;
            next = next.next;
        }
        head.next = prev;
        prev = head;
        return prev;
    }
}
