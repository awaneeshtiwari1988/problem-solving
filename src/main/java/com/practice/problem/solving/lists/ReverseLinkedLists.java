package com.practice.problem.solving.lists;

public class ReverseLinkedLists {

    //   1 -> 2 -> 3 -> 4 -> 5
    //p <-c    n
    //null <- 1  2->3->4->5
    //        p  cn
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
