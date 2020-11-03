package com.a3nv.solutions;

public class M147InsertionSortList extends ASolution {

    public static ListNode insertionListNode(ListNode head) {

        ListNode pseudoHead = new ListNode(); // initially pseudo head has [0] val
        ListNode curr = head, prevNode, nextNode;

        // iterate until next item exists
        while (curr != null) {

            prevNode = pseudoHead;
            nextNode = pseudoHead.next;


            while (nextNode != null) {
                if (curr.val < nextNode.val) {
                    break;
                }
                prevNode = nextNode;
                nextNode = nextNode.next;
            }

            // let's store remaining part into temp var (subsequence starting from the next item of the current)
            ListNode nextIter = curr.next;
            //
            curr.next = nextNode;
            prevNode.next = curr;

            curr = nextIter;
        }

        return pseudoHead.next;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(4, new ListNode(3, new ListNode(5)));
        System.out.println(n);
        n = insertionListNode(n);
        System.out.println(n);

        n = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        System.out.println(n);
        n = insertionListNode(n);
        System.out.println(n);
    }
}
