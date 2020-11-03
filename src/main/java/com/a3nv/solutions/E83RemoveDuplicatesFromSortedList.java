package com.a3nv.solutions;

import com.a3nv.util.Node;

public class E83RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        Node n = new Node(1, new Node(1, new Node(2)));
        System.out.println(n);
        n = deleteDuplicates(n);
        System.out.println(n);

        n = new Node(1, new Node(1, new Node(2, new Node(3, new Node(3)))));
        System.out.println(n);
        n = deleteDuplicates(n);
        System.out.println(n);
    }

    public static Node deleteDuplicates(Node head) {
        Node result = null;
        Node lastNode = new Node();
        Node current = head;
        Node next = head.getNext();
        while (head.getNext() != null) {
            if (current.getVal() == next.getVal()) {
                result = new Node(next.getVal());
                lastNode = next;
                current = next;
                next = next.getNext();
            } else {
                lastNode.setVal(next.getVal());
                result = new Node(current.getVal(), lastNode);
                current = next;
                next = next.getNext();
            }
        }
        return result;
    }
}
