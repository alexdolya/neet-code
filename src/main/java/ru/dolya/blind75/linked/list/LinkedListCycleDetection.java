package ru.dolya.blind75.linked.list;

import java.util.HashSet;
import java.util.Set;

import static ru.dolya.blind75.linked.list.util.ListNodeUtil.createLinkedList;

public class LinkedListCycleDetection {

    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1, 2, 5, 1});
        System.out.println(hasCycle(head));

        ListNode head2 = createLinkedList(new int[]{1, 2, 5, 1});
        ListNode cycleClosure = head2.next;
        ListNode cycleEnd = head2;
        while (cycleEnd.next != null) {
            cycleEnd = cycleEnd.next;
        }
        cycleEnd.next = cycleClosure;
        System.out.println(hasCycle(head2));

    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        if (head == null) {
            return false;
        }

        while (head.next != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

}
