package com.a3nv.solutions;

public abstract class ASolution {

    protected static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(val);
            ListNode child = next;
            while (child != null) {
                sb.append(",").append(child.val);
                child = child.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
