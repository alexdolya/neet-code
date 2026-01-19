
package ru.dolya.blind75.linked.list;

import static ru.dolya.blind75.linked.list.util.ListNodeUtil.createLinkedList;
import static ru.dolya.blind75.linked.list.util.ListNodeUtil.printLinkedList;

public class ReorderLinkedList {

    public static void main(String[] args) {
        ListNode linkedList2 = createLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        reorderList(linkedList2);
        printLinkedList(linkedList2);

        ListNode linkedList = createLinkedList(new int[]{2, 4, 6, 8, 10});
        reorderList(linkedList);
        printLinkedList(linkedList);
    }

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondPartHead = slow.next;
        slow.next = null;

        ListNode reverse = reverse(secondPartHead);

        ListNode first = head;
        ListNode second = reverse;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

    private static ListNode reverse(ListNode head) {
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
