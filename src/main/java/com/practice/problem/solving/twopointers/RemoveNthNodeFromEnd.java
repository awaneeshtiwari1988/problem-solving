package com.practice.problem.solving.twopointers;

public class RemoveNthNodeFromEnd {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode leftNode = head;
        ListNode rightNode = head;

        // Move rightNode n steps forward
        for (int i = 0; i < n; i++) {
            rightNode = rightNode.next;
        }

        if(rightNode == null){
            return head.next;
        }

        while (rightNode.next != null){
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }

        leftNode.next = leftNode.next.next;
        return head;
    }
}
