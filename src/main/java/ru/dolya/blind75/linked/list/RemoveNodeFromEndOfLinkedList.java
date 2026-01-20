package ru.dolya.blind75.linked.list;

import static ru.dolya.blind75.linked.list.util.ListNodeUtil.createLinkedList;
import static ru.dolya.blind75.linked.list.util.ListNodeUtil.printLinkedList;

public class RemoveNodeFromEndOfLinkedList {

    public static void main(String[] args) {
        ListNode linkedList1 = createLinkedList(new int[]{5});
        printLinkedList(removeNthFromEnd(linkedList1, 1));
        ListNode linkedList2 = createLinkedList(new int[]{1, 2, 3, 4});
        printLinkedList(removeNthFromEnd(linkedList2, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int counter = 1;
        ListNode begin = head;
        while (begin.next != null) {
            begin = begin.next;
            counter++;
        }

        int target = counter - n;
        counter = 0;
        ListNode prev = head;
        ListNode current = head.next;
        if (target == 0){
            return current;
        }
        while (current != null) {
            if (counter + 1 == target) {
                prev.next = current.next;
                break;
            }
            prev = current;
            current = current.next;
            counter++;
        }

        return head;
    }
}
