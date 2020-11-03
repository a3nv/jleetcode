package com.a3nv.solutions.crap;


import com.a3nv.solutions.ASolution;

import java.util.ArrayList;
import java.util.List;

public class M147InsertionSortList extends ASolution {

    public static ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return null;
        }
        ListNode next = head;
        do {
            int nextVal = next.val;
            int index = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                Integer last = list.get(i);
                if (nextVal < last) {
                    continue;
                }
                index = i + 1;
                break;
            }
            list.add(index, nextVal);
            next = next.next;
        } while (next != null);
        ListNode res = null;
        ListNode last = null;
        for (Integer val : list) {
            if (last == null) {
                last = new ListNode(val);
                res = last;
            } else {
                last.next = new ListNode(val);
                last = last.next;
            }
        }
        return res;
    }

    /**
     * Input: 4->2->1->3
     * Output: 1->2->3->4
     * @param args arguments
     */
    public static void main(String[] args) {
        ListNode n = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.println(n);
        n = insertionSortList(n);
        System.out.println(n);

        n = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        System.out.println(n);
        n = insertionSortList(n);
        System.out.println(n);
    }
}

