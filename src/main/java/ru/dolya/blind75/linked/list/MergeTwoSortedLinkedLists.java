package ru.dolya.blind75.linked.list;

import static ru.dolya.blind75.linked.list.util.ListNodeUtil.createLinkedList;
import static ru.dolya.blind75.linked.list.util.ListNodeUtil.printLinkedList;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        ListNode linkedList = createLinkedList(new int[]{1, 2, 5, 1});
        ListNode linkedList2 = createLinkedList(new int[]{1, 3, 4});

        printLinkedList(mergeTwoLists(linkedList, linkedList2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mock = new ListNode(0, null);
        ListNode tail = mock;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail= tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }

        return mock.next;
    }
}
