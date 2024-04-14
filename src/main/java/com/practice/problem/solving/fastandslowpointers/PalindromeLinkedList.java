package com.practice.problem.solving.fastandslowpointers;

public class PalindromeLinkedList {

    public static class ListNode {
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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseList = reverseLinkedList(slow);
        boolean check = compareTwoHalves(head, reverseList);
        reverseLinkedList(reverseList);

        if (check) {
            return true;
        }

        return false;
    }

    private ListNode reverseLinkedList(ListNode slow) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = slow;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static boolean compareTwoHalves(ListNode firstHalf, ListNode secondHalf) {
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            } else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
        }

        return true;
    }
}
