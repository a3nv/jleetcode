package com.a3nv.solutions;

import com.a3nv.util.ListNode;

public class E83RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode n = new ListNode(1, new ListNode(1, new ListNode(2)));
        System.out.println(n);
        n = deleteDuplicates(n);
        System.out.println(n);

        n = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.println(n);
        n = deleteDuplicates(n);
        System.out.println(n);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = null;
        ListNode lastListNode = new ListNode();
        ListNode current = head;
        ListNode next = head.getNext();
        while (head.getNext() != null) {
            if (current.getVal() == next.getVal()) {
                result = new ListNode(next.getVal());
                lastListNode = next;
                current = next;
                next = next.getNext();
            } else {
                lastListNode.setVal(next.getVal());
                result = new ListNode(current.getVal(), lastListNode);
                current = next;
                next = next.getNext();
            }
        }
        return result;
    }
}
