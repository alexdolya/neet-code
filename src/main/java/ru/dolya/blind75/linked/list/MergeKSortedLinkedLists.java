package ru.dolya.blind75.linked.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.dolya.blind75.linked.list.util.ListNodeUtil.createLinkedList;
import static ru.dolya.blind75.linked.list.util.ListNodeUtil.printLinkedList;

public class MergeKSortedLinkedLists {

    public static void main(String[] args) {
        ListNode linkedList1 = createLinkedList(new int[]{1, 2, 4});
        ListNode linkedList2 = createLinkedList(new int[]{1, 3, 5});
        ListNode linkedList3 = createLinkedList(new int[]{3, 6});

        printLinkedList(mergeKLists(new ListNode[]{linkedList1, linkedList2, linkedList3}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> vals = new ArrayList<>();

        for (ListNode list : lists) {
            ListNode current = list;
            while (current != null) {
                vals.add(current.val);
                current = current.next;
            }
        }

        Collections.sort(vals);

        ListNode res = new ListNode(0);
        ListNode cur = res;
        for (int val : vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return res.next;
    }
}
