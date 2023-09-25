package com.practice.problem.solving.lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListNode {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0);
        ListNode nextNode = listNode;

        while (true) {
            if(list1 == null){
                nextNode.next = list2;
                break;
            } else if(list2 == null){
                nextNode.next = list1;
                break;
            } else {
                if (list1.val <= list2.val) {
                    nextNode.next = list1;
                    list1 = list1.next;
                } else {
                    nextNode.next = list2;
                    list2 = list2.next;
                }
            }

            nextNode = nextNode.next;
        }

        return listNode.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode;

        while(currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        head = previousNode;
        return head;
    }

    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode tempNode = head;
        while(tempNode != null){
            length++;
            tempNode = tempNode.next;
        }

        int middleIndex = length/2;

        while(middleIndex > 0 && head != null){
            middleIndex--;
            head = head.next;
        }

        return head;
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)){
                return head;
            }

            set.add(head);
            head = head.next;
        }

        return null;
    }
}
